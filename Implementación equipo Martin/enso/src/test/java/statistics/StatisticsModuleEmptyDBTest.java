package statistics;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import DAO.DAOModule;

public class StatisticsModuleEmptyDBTest {

	static StatisticsInterface testClass;
	static DAOModule daoModule;
	
	@BeforeClass
	public static void loadModule() {
		String SCHEMA = "ensop8";
	    String DB_URL = "jdbc:mysql://localhost:3306/";

	   //  Database credentials
	    String USER = "enso";
	    String PASS = "enso";
		testClass = new StatisticsModule(SCHEMA, DB_URL, USER, PASS);
		daoModule = new DAOModule(SCHEMA, DB_URL, USER, PASS);
	}
	
	@Test
	public void testgetValoresBrutosC2_1() {
		assertArrayEquals(new int[] {0}, testClass.getValoresBrutos(1));
	}

}
