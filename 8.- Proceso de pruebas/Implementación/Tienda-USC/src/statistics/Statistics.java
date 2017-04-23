package statistics;

import model.IDAOSell;
import model.IDataAccess;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Statistics implements IStatistics {
	public int calculateLastWeekSellCount() {
		IDAOSell sellDAO = IDataAccess.getDAOFactory(IDataAccess.JDBC_FACTORY).getSellDAO();

        LocalDate now = LocalDate.now();
        LocalDate lastWeek = now.minusWeeks(1);

        return sellDAO.calculateSellCount(Date.from(lastWeek.atStartOfDay(ZoneId.systemDefault()).toInstant()),
				Date.from(now.atStartOfDay(ZoneId.systemDefault()).toInstant()));
	}

	public int calculateLastMonthSellCount() {
		IDAOSell sellDAO = IDataAccess.getDAOFactory(IDataAccess.JDBC_FACTORY).getSellDAO();

        LocalDate now = LocalDate.now();
        LocalDate lastMonth = now.minusMonths(1);

		return sellDAO.calculateSellCount(Date.from(lastMonth.atStartOfDay(ZoneId.systemDefault()).toInstant()),
				Date.from(now.atStartOfDay(ZoneId.systemDefault()).toInstant()));
	}

	public int calculateLastYearSellCount() {
		IDAOSell sellDAO = IDataAccess.getDAOFactory(IDataAccess.JDBC_FACTORY).getSellDAO();

        LocalDate now = LocalDate.now();
        LocalDate lastYear = now.minusYears(1);

        return sellDAO.calculateSellCount(Date.from(lastYear.atStartOfDay(ZoneId.systemDefault()).toInstant()),
				Date.from(now.atStartOfDay(ZoneId.systemDefault()).toInstant()));
	}

	public float calculateLastMonthDailyAverageSells() {
		IDAOSell sellDAO = IDataAccess.getDAOFactory(IDataAccess.JDBC_FACTORY).getSellDAO();

        LocalDate now = LocalDate.now();
        LocalDate lastMonth = now.minusMonths(1);

		return sellDAO.calculateDailyAverageSells(Date.from(lastMonth.atStartOfDay(ZoneId.systemDefault()).toInstant()),
				Date.from(now.atStartOfDay(ZoneId.systemDefault()).toInstant()));
	}

	public float calculateLastYearWeeklyAverageSells() {
		IDAOSell sellDAO = IDataAccess.getDAOFactory(IDataAccess.JDBC_FACTORY).getSellDAO();

        LocalDate now = LocalDate.now();
        LocalDate lastYear = now.minusYears(1);

		return sellDAO.calculateWeeklyAverageSells(Date.from(lastYear.atStartOfDay(ZoneId.systemDefault()).toInstant()),
				Date.from(now.atStartOfDay(ZoneId.systemDefault()).toInstant()));
	}

	public int[] calculateLastMonthDailySellCount() {
		IDAOSell sellDAO = IDataAccess.getDAOFactory(IDataAccess.JDBC_FACTORY).getSellDAO();

        LocalDate now = LocalDate.now();
        LocalDate lastMonth = now.minusMonths(1);

		return sellDAO.calculateDailySellCount(Date.from(lastMonth.atStartOfDay(ZoneId.systemDefault()).toInstant()),
				Date.from(now.atStartOfDay(ZoneId.systemDefault()).toInstant()));
	}

	public int[] calculateLastYearWeeklySellCount() {
		IDAOSell sellDAO = IDataAccess.getDAOFactory(IDataAccess.JDBC_FACTORY).getSellDAO();

        LocalDate now = LocalDate.now();
        LocalDate lastYear = now.minusYears(1);

		return sellDAO.calculateWeeklySellCount(Date.from(lastYear.atStartOfDay(ZoneId.systemDefault()).toInstant()),
				Date.from(now.atStartOfDay(ZoneId.systemDefault()).toInstant()));
	}

	public float[] calculateLastWeekDailyRelativeSells() {
		IDAOSell sellDAO = IDataAccess.getDAOFactory(IDataAccess.JDBC_FACTORY).getSellDAO();

        LocalDate now = LocalDate.now();
        LocalDate lastWeek = now.minusWeeks(1);

		return sellDAO.calculateDailyRelativeSells(Date.from(lastWeek.atStartOfDay(ZoneId.systemDefault()).toInstant()),
				Date.from(now.atStartOfDay(ZoneId.systemDefault()).toInstant()));
	}

	public float[] calculateLastYearWeeklyRelativeSells() {
		IDAOSell sellDAO = IDataAccess.getDAOFactory(IDataAccess.JDBC_FACTORY).getSellDAO();

        LocalDate now = LocalDate.now();
        LocalDate lastYear = now.minusYears(1);

		return sellDAO.calculateWeeklyRelativeSells(Date.from(lastYear.atStartOfDay(ZoneId.systemDefault()).toInstant()),
				Date.from(now.atStartOfDay(ZoneId.systemDefault()).toInstant()));
	}
}