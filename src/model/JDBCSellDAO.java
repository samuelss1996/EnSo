package model;

import model.IDAOSell;

import java.util.Date;

public class JDBCSellDAO implements IDAOSell {
    @Override
    public void addSell(Sell sell) {

    }

    @Override
    public Sell querySell(int sellId) {
        return null;
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
