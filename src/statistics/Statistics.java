package statistics;

import model.IDAOSell;
import model.IDataAccess;

import java.time.LocalDate;
import java.util.Date;

public class Statistics implements IStatistics {
	public int calculateLastWeekSellCount() {
		IDAOSell sellDAO = IDataAccess.getDAOFactory(IDataAccess.JDBC_FACTORY).getSellDAO();

        LocalDate now = LocalDate.now();
        LocalDate lastWeek = now.minusWeeks(1);

        return sellDAO.calculateSellCount(new Date(lastWeek.toEpochDay()), new Date(now.toEpochDay()));
	}

	public int calculateLastMonthSellCount() {
		IDAOSell sellDAO = IDataAccess.getDAOFactory(IDataAccess.JDBC_FACTORY).getSellDAO();

        LocalDate now = LocalDate.now();
        LocalDate lastMonth = now.minusMonths(1);

		return sellDAO.calculateSellCount(new Date(lastMonth.toEpochDay()), new Date(now.toEpochDay()));
	}

	public int calculateLastYearSellCount() {
		IDAOSell sellDAO = IDataAccess.getDAOFactory(IDataAccess.JDBC_FACTORY).getSellDAO();

        LocalDate now = LocalDate.now();
        LocalDate lastYear = now.minusYears(1);

        return sellDAO.calculateSellCount(new Date(lastYear.toEpochDay()), new Date(now.toEpochDay()));
	}

	public float calculateLastMonthDailyAverageSells() {
		IDAOSell sellDAO = IDataAccess.getDAOFactory(IDataAccess.JDBC_FACTORY).getSellDAO();

        LocalDate now = LocalDate.now();
        LocalDate lastMonth = now.minusMonths(1);

		return sellDAO.calculateDailyAverageSells(new Date(lastMonth.toEpochDay()), new Date(now.toEpochDay()));
	}

	public float calculateLastYearWeeklyAverageSells() {
		IDAOSell sellDAO = IDataAccess.getDAOFactory(IDataAccess.JDBC_FACTORY).getSellDAO();

        LocalDate now = LocalDate.now();
        LocalDate lastYear = now.minusYears(1);

		return sellDAO.calculateWeeklyAverageSells(new Date(lastYear.toEpochDay()), new Date(now.toEpochDay()));
	}

	public int[] calculateLastMonthDailySellCount() {
		IDAOSell sellDAO = IDataAccess.getDAOFactory(IDataAccess.JDBC_FACTORY).getSellDAO();

        LocalDate now = LocalDate.now();
        LocalDate lastMonth = now.minusMonths(1);

		return sellDAO.calculateDailySellCount(new Date(lastMonth.toEpochDay()), new Date(now.toEpochDay()));
	}

	public int[] calculateLastYearWeeklySellCount() {
		IDAOSell sellDAO = IDataAccess.getDAOFactory(IDataAccess.JDBC_FACTORY).getSellDAO();

        LocalDate now = LocalDate.now();
        LocalDate lastYear = now.minusYears(1);

		return sellDAO.calculateWeeklySellCount(new Date(lastYear.toEpochDay()), new Date(now.toEpochDay()));
	}

	public float[] calculateLastWeekDailyRelativeSells() {
		IDAOSell sellDAO = IDataAccess.getDAOFactory(IDataAccess.JDBC_FACTORY).getSellDAO();

        LocalDate now = LocalDate.now();
        LocalDate lastWeek = now.minusWeeks(1);

		return sellDAO.calculateDailyRelativeSells(new Date(lastWeek.toEpochDay()), new Date(now.toEpochDay()));
	}

	public float[] calculateLastYearWeeklyRelativeSells() {
		IDAOSell sellDAO = IDataAccess.getDAOFactory(IDataAccess.JDBC_FACTORY).getSellDAO();

        LocalDate now = LocalDate.now();
        LocalDate lastYear = now.minusYears(1);

		return sellDAO.calculateWeeklyRelativeSells(new Date(lastYear.toEpochDay()), new Date(now.toEpochDay()));
	}
}