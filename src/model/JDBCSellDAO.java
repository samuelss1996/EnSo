package model;

import model.data.Sell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class JDBCSellDAO implements IDAOSell {

    //Inserta una nueva venta
    @Override
    public void addSell(Sell sell) {
        try(Connection connection = DriverManager.getConnection(URL_bd,username, password)){
            connection.setAutoCommit(false);
            PreparedStatement preparedStmt=connection.prepareStatement("INSERT INTO sell (totalPrice, sellDate, idUser)" +
                    "VALUES (?,?,?);");
            preparedStmt.setFloat(1, sell.getTotalPrice());
            preparedStmt.setDate(2, new java.sql.Date(sell.getSellDate().getTime()));
            preparedStmt.setString(3, sell.getIduser());
            try{
                preparedStmt.execute();
                connection.commit();
            }catch(SQLException e){
                e.printStackTrace();
                connection.rollback();
            }finally {
                preparedStmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Busca una venta por su id
    @Override
    public Sell querySell(String sellId) {
        Sell sell = new Sell();

        try(Connection connection = DriverManager.getConnection(URL_bd, username, password)){
            connection.setAutoCommit(false);
            PreparedStatement queryStm = connection.prepareStatement("SELECT * FROM sell WHERE id=?;");
            queryStm.setString(1, sellId);
            try{
                ResultSet resultSet = queryStm.executeQuery();
                if(resultSet.first()){
                    sell.setId(resultSet.getString("id"));
                    sell.setTotalPrice(resultSet.getFloat("totalPrice"));
                    sell.setSellDate(resultSet.getDate("sellDate"));
                    sell.setUser(resultSet.getString("idUser"));
                }
                connection.commit();
            }catch (SQLException e){
                e.printStackTrace();
                connection.rollback();
            }finally {
                queryStm.close();
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
        try(Connection connection = DAOFactoryJDBC.createConnection()){
            try{
                PreparedStatement queryStm = connection.prepareStatement("SELECT count(*) FROM sell where sellDate BETWEEN " +
                        "? and ?;");
                queryStm.setDate(1,  new java.sql.Date(from.getTime()));
                queryStm.setDate(2,  new java.sql.Date(to.getTime()));
                ResultSet resultSet = queryStm.executeQuery();
                if(resultSet.first()){
                    count = resultSet.getInt(1);
                }
            }catch (SQLException e){
                e.printStackTrace();
                connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    //Calcula la media de ventas por dia para un intervalo dado
    @Override
    public float calculateDailyAverageSells(Date from, Date to) {
        int dias = (int)((from.getTime() - to.getTime())/(1000/60/60/24));
        int count = 0;
        float media = 0.0f;

        try(Connection connection = DAOFactoryJDBC.createConnection()){
            try{
                PreparedStatement queryStm = connection.prepareStatement("SELECT count(*) FROM sell where sellDate BETWEEN " +
                        "? and ?;");
                queryStm.setDate(1,  new java.sql.Date(from.getTime()));
                queryStm.setDate(2,  new java.sql.Date(to.getTime()));
                ResultSet resultSet = queryStm.executeQuery();
                if(resultSet.first()){
                    count = resultSet.getInt(1);
                    media = count/dias;
                }
            }catch (SQLException e){
                e.printStackTrace();
                connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return media;
    }

    //Calcula la media de ventas por semana para un intervalo dado
    @Override
    public float calculateWeeklyAverageSells(Date from, Date to) {
        int semanas = (int)((from.getTime() - to.getTime())/(1000/60/60/24/7));
        int count = 0;
        float media = 0.0f;
        try(Connection connection = DAOFactoryJDBC.createConnection()){
            try{
                PreparedStatement queryStm = connection.prepareStatement("SELECT count(*) FROM sell where sellDate BETWEEN " +
                        "? and ?;");
                queryStm.setDate(1,  new java.sql.Date(from.getTime()));
                queryStm.setDate(2,  new java.sql.Date(to.getTime()));
                ResultSet resultSet = queryStm.executeQuery();
                if(resultSet.first()){
                    count = resultSet.getInt(1);
                    media = count/semanas;
                }
            }catch (SQLException e){
                e.printStackTrace();
                connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return media;
    }

    //Calcula las ventas por dia para un intervalo dado
    @Override
    public int[] calculateDailySellCount(Date from, Date to) {
        int[] ventas = new int[0];
        try(Connection connection = DAOFactoryJDBC.createConnection()){
            try{
                PreparedStatement queryStm = connection.prepareStatement("select count(*) as 'ventas' from sell where sellDate " +
                        "BETWEEN ? and ? group by sellDate;");
                queryStm.setDate(1,  new java.sql.Date(from.getTime()));
                queryStm.setDate(2,  new java.sql.Date(to.getTime()));
                ResultSet resultSet = queryStm.executeQuery();
                int i = 0;
                while(resultSet.next()){
                    ventas[i]=resultSet.getInt(1);
                    i++;
                }
            }catch (SQLException e){
                e.printStackTrace();
                connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ventas;
    }

    //Calcula las ventas por semana para un intervalo dado
    @Override
    public int[] calculateWeeklySellCount(Date from, Date to) {
        int[] ventas = new int[0];
        try(Connection connection = DAOFactoryJDBC.createConnection()){
            try{
                PreparedStatement queryStm = connection.prepareStatement("SELECT count(*) FROM sell where sellDate BETWEEN " +
                        "? and ?;");
                queryStm.setDate(1,  new java.sql.Date(from.getTime()));
                queryStm.setDate(2,  new java.sql.Date(to.getTime()));
                ResultSet resultSet = queryStm.executeQuery();
                int i = 0;
                while(resultSet.next()){
                    ventas[i]=resultSet.getInt(1);
                    i++;
                }
            }catch (SQLException e){
                e.printStackTrace();
                connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ventas;
    }

    //Calcula el % de ventas que hay cada dia en base al total del mes
    @Override
    public float[] calculateDailyRelativeSells(Date from, Date to) {
        float[] porcentajeVentas = new float[0];
        int ventasTotales=0;
        int[] ventasDiarias = new int[0];
        try(Connection connection = DAOFactoryJDBC.createConnection()){
            try{
                connection.setAutoCommit(false);
                PreparedStatement queryStm = connection.prepareStatement("select count(*) as ventasTotales from sell where sellDate between ? and ?");
                queryStm.setDate(1,  new java.sql.Date(from.getTime()));
                queryStm.setDate(2,  new java.sql.Date(to.getTime()));
                ResultSet resultSet = queryStm.executeQuery();
                if(resultSet.first()){
                    ventasTotales = resultSet.getInt(1);
                }

                PreparedStatement queryStm2 = connection.prepareStatement("select count(*) as ventasDiarias from sell where sellDate between ? and ? GROUP BY sellDate");
                queryStm2.setDate(1,  new java.sql.Date(from.getTime()));
                queryStm2.setDate(2,  new java.sql.Date(to.getTime()));
                ResultSet resultSet2 = queryStm2.executeQuery();
                int i = 0;
                while(resultSet2.next()) {
                    i++;
                    ventasDiarias[i] = resultSet2.getInt(1);
                }
                for(int j=0;j<ventasDiarias.length;j++){
                    porcentajeVentas[j] = (ventasDiarias[j]*100)/ventasTotales;
                }
                connection.commit();
            }catch (SQLException e){
                e.printStackTrace();
                connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return porcentajeVentas;
    }

    //Calcula el % de ventas que hay cada semana en base al total anual
    @Override
    public float[] calculateWeeklyRelativeSells(Date from, Date to) {
        float[] porcentajeVentas = new float[0];
        int ventasTotalesAnuales=0;
        int[] ventasSemanales = new int[0];
        try(Connection connection = DAOFactoryJDBC.createConnection()){
            try{
                connection.setAutoCommit(false);
                PreparedStatement queryStm = connection.prepareStatement("select count(*) as ventasTotales from sell where sellDate between '2017-01-01' and '2017-12-31'");
                ResultSet resultSet = queryStm.executeQuery();
                if(resultSet.first()){
                    ventasTotalesAnuales = resultSet.getInt(1);
                }

                PreparedStatement queryStm2 = connection.prepareStatement("select count(*) as ventasSemanales from sell where sellDate between ? and ? GROUP BY sellDate");
                queryStm2.setDate(1,  new java.sql.Date(from.getTime()));
                queryStm2.setDate(2,  new java.sql.Date(to.getTime()));
                ResultSet resultSet2 = queryStm2.executeQuery();
                int i = 0;
                while(resultSet2.next()) {
                    i++;
                    ventasSemanales[i] = resultSet2.getInt(1);
                }
                for(int j=0;j<ventasSemanales.length;j++){
                    porcentajeVentas[j] = (ventasSemanales[j]*100)/ventasTotalesAnuales;
                }
                connection.commit();
            }catch (SQLException e){
                e.printStackTrace();
                connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return porcentajeVentas;
    }
}