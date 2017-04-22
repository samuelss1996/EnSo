package model;

import model.data.Sell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.*;

public class JDBCSellDAO implements IDAOSell {

    //Inserta una nueva venta
    @Override
    public void addSell(Sell sell) {
        try (Connection connection = DAOFactoryJDBC.createConnection()) {
            try (PreparedStatement preparedStmt = connection.prepareStatement("INSERT INTO sell (totalPrice, sellDate, idUser) VALUES (?,?,?);")) {
                preparedStmt.setFloat(1, sell.getTotalPrice());
                preparedStmt.setDate(2, new java.sql.Date(sell.getSellDate().getTime()));
                preparedStmt.setString(3, sell.getIduser());

                preparedStmt.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Busca una venta por su id
    @Override
    public Sell querySell(String sellId) {
        Sell sell = new Sell();

        try (Connection connection = DAOFactoryJDBC.createConnection()) {
            try (PreparedStatement queryStm = connection.prepareStatement("SELECT * FROM sell WHERE id=?;")) {
                queryStm.setString(1, sellId);

                ResultSet resultSet = queryStm.executeQuery();
                if (resultSet.first()) {
                    sell.setId(resultSet.getString("id"));
                    sell.setTotalPrice(resultSet.getFloat("totalPrice"));
                    sell.setSellDate(resultSet.getDate("sellDate"));
                    sell.setUser(resultSet.getString("idUser"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sell;
    }

    //Calcula el numero de ventas en un intervalo dado
    @Override
    public int calculateSellCount(Date from, Date to) {
        int count = 0;
        try (Connection connection = DAOFactoryJDBC.createConnection()) {
            try (PreparedStatement queryStm = connection.prepareStatement("SELECT count(*) FROM sell WHERE sellDate BETWEEN ? AND ?;")) {
                queryStm.setDate(1, new java.sql.Date(from.getTime()));
                queryStm.setDate(2, new java.sql.Date(to.getTime()));
                ResultSet resultSet = queryStm.executeQuery();
                if (resultSet.first()) {
                    count = resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    //Calcula la media de ventas por dia para un intervalo dado
    @Override
    public float calculateDailyAverageSells(Date from, Date to) {
        int dias = (int) ((from.getTime() - to.getTime()) / (1000 / 60 / 60 / 24));

        return calculateSellCount(from, to) / (float) dias;
    }

    //Calcula la media de ventas por semana para un intervalo dado
    @Override
    public float calculateWeeklyAverageSells(Date from, Date to) {
        int semanas = (int) ((from.getTime() - to.getTime()) / (1000 / 60 / 60 / 24 / 7));

        return calculateSellCount(from, to) / (float) semanas;
    }

    //Calcula las ventas por dia para un intervalo dado
    @Override
    public int[] calculateDailySellCount(Date from, Date to) {
        List<Integer> ventas = new ArrayList<>();
        try (Connection connection = DAOFactoryJDBC.createConnection()) {
            LocalDate start = from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate end = to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();


            try (PreparedStatement queryStm = connection.prepareStatement("SELECT count(*) FROM sell WHERE DAY(sellDate) = ? AND MONTH(sellDate) = ? AND YEAR(sellDate) = ?")) {
                for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
                    queryStm.setInt(1, date.getDayOfMonth());
                    queryStm.setInt(2, date.getMonthValue());
                    queryStm.setInt(3, date.getYear());

                    ResultSet resultSet = queryStm.executeQuery();

                    while (resultSet.next()) {
                        ventas.add(resultSet.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ventas.stream().mapToInt(i -> i).toArray();
    }

    //Calcula las ventas por semana para un intervalo dado
    @Override
    public int[] calculateWeeklySellCount(Date from, Date to) {
        List<Integer> ventas = new ArrayList<>();
        try (Connection connection = DAOFactoryJDBC.createConnection()) {
            LocalDate start = from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate end = to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            TemporalField weekTemporalField = WeekFields.ISO.weekOfWeekBasedYear();

            try (PreparedStatement queryStm = connection.prepareStatement("SELECT count(*) FROM sell WHERE WEEK(sellDate, 3) = ? AND YEAR(sellDate) = ?")) {
                for (LocalDate date = start; date.isBefore(end); date = date.plusDays(7)) {
                    queryStm.setInt(1, date.get(weekTemporalField));
                    queryStm.setInt(2, date.getYear());

                    ResultSet resultSet = queryStm.executeQuery();

                    while (resultSet.next()) {
                        ventas.add(resultSet.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ventas.stream().mapToInt(i -> i).toArray();
    }

    //Calcula el % de ventas que hay cada dia en base al total del periodo establecido
    @Override
    public float[] calculateDailyRelativeSells(Date from, Date to) {
        int[] dailySells = calculateDailySellCount(from, to);
        int total = 0;

        for (int i = 0; i < dailySells.length; i++)
            total += dailySells[i];

        float[] relativeSells = new float[dailySells.length];

        for (int i = 0; i < dailySells.length; i++)
            relativeSells[i] = dailySells[i] / (float) total;

        return relativeSells;
    }

    //Calcula el % de ventas que hay cada semana en base al total del periodo establecido
    @Override
    public float[] calculateWeeklyRelativeSells(Date from, Date to) {
        int[] weeklySells = calculateWeeklySellCount(from, to);
        int total = 0;

        for (int i = 0; i < weeklySells.length; i++)
            total += weeklySells[i];

        float[] relativeSells = new float[weeklySells.length];

        for (int i = 0; i < weeklySells.length; i++)
            relativeSells[i] = weeklySells[i] / (float) total;

        return relativeSells;
    }
}