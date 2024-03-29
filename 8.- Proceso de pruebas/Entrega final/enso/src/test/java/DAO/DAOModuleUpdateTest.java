package DAO;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Item;
import model.User;

public class DAOModuleUpdateTest {
	private static final String DB_SCHEMA = "ensop8";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/";
	private static final String DB_USER = "enso";
	private static final String DB_PASSWORD = "enso";
	
	private static DAOModule daoModule;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		daoModule = new DAOModule(DB_SCHEMA, DB_URL, DB_USER, DB_PASSWORD);
	}
	
	@Test
	public void testD02P05() {
		assertFalse(daoModule.updateItem(new Item("I-abcde-999", "Maletín de cuero", "Maletín de portátil", "Accesorios", 50, Date.valueOf("2010-10-10"))));
	}

	@Test
	public void testD01P06() {
		assertTrue(daoModule.modUsuario(new User("U-abcde-000", "Manuel", "Soutoullo", "77013889E", Date.valueOf("2010-10-10"), User.ALUMN)));
	}
	
	@Test
	public void testD01P07() {
		assertFalse(daoModule.modUsuario(new User("U-ddddd-000", "Manuel", "Soutoullo", "77013889E", Date.valueOf("2010-10-10"), User.ALUMN)));
	}
	
	@Test
	public void testD02P02() {
		assertTrue(daoModule.updateItem(new Item("I-abcde-000", "Robot limpiapiscinas", "Limpia piscinas de forma eficiente", "Exteriores", 50,
				Date.valueOf("2010-10-10"))));
	}
}