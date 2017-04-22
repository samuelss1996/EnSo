package statistics;

import model.DAOFactoryJDBC;
import model.JDBCSellDAO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Statistics implements IStatistics {
	public int calculateLastWeekSellCount() {
		DAOFactoryJDBC factoryJDBC = new DAOFactoryJDBC();
		JDBCSellDAO sellDAO = (JDBCSellDAO) factoryJDBC.getSellDAO();

		Date from = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -7);
		Date to = cal.getTime();

		return sellDAO.calculateSellCount(to, from);
	}

	public int calculateLastMonthSellCount() {
		DAOFactoryJDBC factoryJDBC = new DAOFactoryJDBC();
		JDBCSellDAO sellDAO = (JDBCSellDAO) factoryJDBC.getSellDAO();

		Date from = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -31);
		Date to = cal.getTime();

		return sellDAO.calculateSellCount(to, from);
	}

	public int calculateLastYearSellCount() {
		DAOFactoryJDBC factoryJDBC = new DAOFactoryJDBC();
		JDBCSellDAO sellDAO = (JDBCSellDAO) factoryJDBC.getSellDAO();

		Date from = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -365);
		Date to = cal.getTime();

		return sellDAO.calculateSellCount(to, from);
	}

	public float calculateLastMonthDailyAverageSells() {
		DAOFactoryJDBC factoryJDBC = new DAOFactoryJDBC();
		JDBCSellDAO sellDAO = (JDBCSellDAO) factoryJDBC.getSellDAO();

		Date from = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -31);
		Date to = cal.getTime();

		return sellDAO.calculateDailyAverageSells(to, from);
	}

	public float calculateLastYearWeeklyAverageSells() {
		DAOFactoryJDBC factoryJDBC = new DAOFactoryJDBC();
		JDBCSellDAO sellDAO = (JDBCSellDAO) factoryJDBC.getSellDAO();

		Date from = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -365);
		Date to = cal.getTime();

		return sellDAO.calculateWeeklyAverageSells(to, from);
	}

	public int[] calculateLastMonthDailySellCount() {
		DAOFactoryJDBC factoryJDBC = new DAOFactoryJDBC();
		JDBCSellDAO sellDAO = (JDBCSellDAO) factoryJDBC.getSellDAO();

		Date from = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -31);
		Date to = cal.getTime();

		return sellDAO.calculateDailySellCount(to, from);
	}

	public int[] calculateLastYearWeeklySellCount() {
		DAOFactoryJDBC factoryJDBC = new DAOFactoryJDBC();
		JDBCSellDAO sellDAO = (JDBCSellDAO) factoryJDBC.getSellDAO();

		Date from = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -365);
		Date to = cal.getTime();

		return sellDAO.calculateWeeklySellCount(to, from);
	}

	public float[] calculateLastWeekDailyRelativeSells() {
		DAOFactoryJDBC factoryJDBC = new DAOFactoryJDBC();
		JDBCSellDAO sellDAO = (JDBCSellDAO) factoryJDBC.getSellDAO();

		Date from = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -7);
		Date to = cal.getTime();

		return sellDAO.calculateDailyRelativeSells(to, from);
	}

	public float[] calculateLastYearWeeklyRelativeSells() {
		DAOFactoryJDBC factoryJDBC = new DAOFactoryJDBC();
		JDBCSellDAO sellDAO = (JDBCSellDAO) factoryJDBC.getSellDAO();

		Date from = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -365);
		Date to = cal.getTime();

		return sellDAO.calculateWeeklyRelativeSells(to, from);
	}
}