package model;


import java.util.Date;

public interface IDAOSell {
	void addSell(Sell sell);

	Sell querySell(int sellId);

	int calculateSellCount(Date from, Date to);

	float calculateDailyAverageSells(Date from, Date to);

	float calculateWeeklyAverageSells(Date from, Date to);

	int[] calculateDailySellCount(Date from, Date to);

	int[] calculateWeeklySellCount(Date from, Date to);

	float[] calculateDailyRelativeSells(Date from, Date to);

	float[] calculateWeeklyRelativeSells(Date from, Date to);
}
