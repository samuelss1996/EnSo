package statistics;


public interface IStatistics {
	int calculateLastWeekSellCount();
	int calculateLastMonthSellCount();
	int calculateLastYearSellCount();
	float calculateLastMonthDailyAverageSells();
	float calculateLastYearWeeklyAverageSells();
	int[] calculateLastMonthDailySellCount();
	int[] calculateLastYearWeeklySellCount();
	float[] calculateLastWeekDailyRelativeSells();
	float[] calculateLastYearWeeklyRelativeSells();
}
