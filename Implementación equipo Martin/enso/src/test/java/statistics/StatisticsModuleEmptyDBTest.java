package statistics;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import DAO.DAOModule;
import model.User;

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
		
		User user = new User("U-AAAAA-001", "Usuaria", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
		daoModule.insertUser(user);
	}
	
	@Test
	public void testgetValoresBrutosC2() {
		assertArrayEquals(new int[] {0}, testClass.getValoresBrutos(1));
	}
	
	@Test
	public void testgetValoresBrutosC4() {		
		assertArrayEquals(new int[]{0}, testClass.getValoresBrutos(1));
	}
	
	@Test
	public void testGetPorcentajesC2() {		
		assertArrayEquals(new float[30], testClass.getPorcentajes(1), 0.01f);
	}
	
	@Test
	public void testGetPorcentajesC4() {
		assertArrayEquals(new float[50], testClass.getPorcentajes(2), 0.01f);
	}
	
	@Test
	public void testGetPorcentajesC5() {
		assertNull(testClass.getPorcentajes(3));
	}
	
	@Test
	public void testgetMediasC2() {
		assertEquals(0.0f, testClass.getMedias(1), 0.00001f);
	}
	
	@Test
	public void testgetMediasC4() {
		assertEquals(0.0f, testClass.getMedias(0), 0.00001f);
	}
}
