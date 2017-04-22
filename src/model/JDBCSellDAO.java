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

    @Override
    public void addSell(Sell sell) {
        try(Connection connection = DAOFactoryJDBC.createConnection()){
            try{
                connection.setAutoCommit(false);
                PreparedStatement preparedStmt=connection.prepareStatement("INSERT INTO sell (totalPrice, sellDate, idUser)" +
                        "VALUES (?,?,?);");
                preparedStmt.setFloat(1, sell.getTotalPrice());
                preparedStmt.setDate(2, new java.sql.Date(sell.getSellDate().getTime())); //TODO: creo que se puede pasar el Date de java normal.
                preparedStmt.setString(3, sell.getIduser());

                preparedStmt.execute();
                connection.commit();
            }catch(SQLException e){
                e.printStackTrace();
                connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Sell querySell(String sellId) {
        Sell sell = new Sell();

        try(Connection connection = DAOFactoryJDBC.createConnection()){
            try{
            PreparedStatement queryStm = connection.prepareStatement("SELECT * FROM sell WHERE id=?;");
            queryStm.setString(1, sellId);
            ResultSet resultSet = queryStm.executeQuery();
            if(resultSet.first()){
                    sell.setId(resultSet.getString("id"));
                    sell.setTotalPrice(resultSet.getFloat("totalPrice"));
                    sell.setSellDate(resultSet.getDate("sellDate"));
                    sell.setUser(resultSet.getString("idUser"));
                }
            }catch (SQLException e){
                e.printStackTrace();
                connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sell;
    }


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

    @Override
    public float calculateWeeklyAverageSells(Date from, Date to) {
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(from);
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(to);
        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
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
                    media = count/diffMonth;
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

    @Override
    public int[] calculateDailySellCount(Date from, Date to) {
        return new int[0];
    }

    @Override
    public int[] calculateWeeklySellCount(Date from, Date to) {
        return new int[0];
    }

    @Override
    public float[] calculateDailyRelativeSells(Date from, Date to) {
        return new float[0];
    }

    @Override
    public float[] calculateWeeklyRelativeSells(Date from, Date to) {
        return new float[0];
    }
}
