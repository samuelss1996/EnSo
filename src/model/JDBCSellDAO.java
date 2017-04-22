package model;

import model.data.Sell;

import java.sql.*;
import java.util.Date;

public class JDBCSellDAO implements IDAOSell {
    private String URL_bd = "jdbc:mysql://127.0.01:3306/enso";
    private String username = "enso";
    private String password = "enso";

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

    @Override
    public int calculateSellCount(Date from, Date to) {


        return 0;
    }

    @Override
    public float calculateDailyAverageSells(Date from, Date to) {
        return 0;
    }

    @Override
    public float calculateWeeklyAverageSells(Date from, Date to) {
        return 0;
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
