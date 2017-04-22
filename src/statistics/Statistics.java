package statistics;

import model.DAOFactoryJDBC;
import model.JDBCSellDAO;

import java.util.Date;

public class Statistics implements IStatistics {
	public int calculateLastWeekSellCount() {
		DAOFactoryJDBC factoryJDBC = new DAOFactoryJDBC();
		JDBCSellDAO sellDAO = (JDBCSellDAO) factoryJDBC.getSellDAO();
		Date to = new Date();
		Date from = new Date();
		to.setTime(Long.parseLong("2017-04-17"));
		from.setTime(Long.parseLong("2017-04-23"));
		return sellDAO.calculateSellCount(to, from);
	}

	public int calculateLastMonthSellCount() {
		DAOFactoryJDBC factoryJDBC = new DAOFactoryJDBC();
		JDBCSellDAO sellDAO = (JDBCSellDAO) factoryJDBC.getSellDAO();
		Date to = new Date();
		Date from = new Date();
		to.setTime(Long.parseLong("2017-03-01"));
		from.setTime(Long.parseLong("2017-03-31"));
		return sellDAO.calculateSellCount(to, from);
	}

	public int calculateLastYearSellCount() {
		DAOFactoryJDBC factoryJDBC = new DAOFactoryJDBC();
		JDBCSellDAO sellDAO = (JDBCSellDAO) factoryJDBC.getSellDAO();
		Date to = new Date();
		Date from = new Date();
		to.setTime(Long.parseLong("2016-01-01"));
		from.setTime(Long.parseLong("2016-12-31"));
		return sellDAO.calculateSellCount(to, from);
	}

	public float calculateLastMonthDailyAverageSells() {
		DAOFactoryJDBC factoryJDBC = new DAOFactoryJDBC();
		JDBCSellDAO sellDAO = (JDBCSellDAO) factoryJDBC.getSellDAO();
		Date to = new Date();
		Date from = new Date();
		to.setTime(Long.parseLong("2017-03-01"));
		from.setTime(Long.parseLong("2017-03-31"));
		return sellDAO.calculateDailyAverageSells(to, from);
	}

	public float calculateLastYearWeeklyAverageSells() {
		DAOFactoryJDBC factoryJDBC = new DAOFactoryJDBC();
		JDBCSellDAO sellDAO = (JDBCSellDAO) factoryJDBC.getSellDAO();
		Date to = new Date();
		Date from = new Date();
		to.setTime(Long.parseLong("2016-01-01"));
		from.setTime(Long.parseLong("2016-12-31"));
		return sellDAO.calculateWeeklyAverageSells(to, from);
	}

	public int[] calculateLastMonthDailySellCount() {
		DAOFactoryJDBC factoryJDBC = new DAOFactoryJDBC();
		JDBCSellDAO sellDAO = (JDBCSellDAO) factoryJDBC.getSellDAO();
		Date to = new Date();
		Date from = new Date();
		to.setTime(Long.parseLong("2017-03-01"));
		from.setTime(Long.parseLong("2017-03-31"));
		return sellDAO.calculateDailySellCount(to, from);
	}

	public int[] calculateLastYearWeeklySellCount() {
		DAOFactoryJDBC factoryJDBC = new DAOFactoryJDBC();
		JDBCSellDAO sellDAO = (JDBCSellDAO) factoryJDBC.getSellDAO();
		Date to = new Date();
		Date from = new Date();
		to.setTime(Long.parseLong("2016-01-01"));
		from.setTime(Long.parseLong("2016-12-31"));
		return sellDAO.calculateWeeklySellCount(to, from);
	}

	public float[] calculateLastWeekDailyRelativeSells() {
		DAOFactoryJDBC factoryJDBC = new DAOFactoryJDBC();
		JDBCSellDAO sellDAO = (JDBCSellDAO) factoryJDBC.getSellDAO();
		Date to = new Date();
		Date from = new Date();
		to.setTime(Long.parseLong("2017-04-17"));
		from.setTime(Long.parseLong("2017-04-23"));
		return sellDAO.calculateDailyRelativeSells(to, from);
	}

	public float[] calculateLastYearWeeklyRelativeSells() {
		DAOFactoryJDBC factoryJDBC = new DAOFactoryJDBC();
		JDBCSellDAO sellDAO = (JDBCSellDAO) factoryJDBC.getSellDAO();
		Date to = new Date();
		Date from = new Date();
		to.setTime(Long.parseLong("2016-01-01"));
		from.setTime(Long.parseLong("2016-12-31"));
		return sellDAO.calculateWeeklyRelativeSells(to, from);
	}
}