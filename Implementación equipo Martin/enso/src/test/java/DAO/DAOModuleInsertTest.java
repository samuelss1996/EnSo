package DAO;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Item;
import model.User;

public class DAOModuleInsertTest {
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
	public void testD01P01() {
		assert daoModule.insertUser(new User("U-abcde-000", "Manuel", "Soutoullo", "77013889E", Date.valueOf("2010-10-10"), User.ALUMN));
	}
	
	@Test
	public void testD01P02() {
		// TODO quizás cambiar nombre
		assert !daoModule.insertUser(new User("x", "Manuel", "Soutoullo", "77013889E", Date.valueOf("2010-10-10"), User.ALUMN));
		assert daoModule.isRegistered("x") == null;
	}
	
	@Test
	public void testD02P01() {
		assert daoModule.insertItem(new Item("I-abcde-000", "Robot limpiapiscinas", "Limpia piscinas", "Exteriores", 50, Date.valueOf("2010-10-10")));
	}
	
	// TODO D02P02
	
	@Test
	public void testD02P04() {
		assert !daoModule.insertItem(new Item("x", "Robot limpiapiscinas", "Limpia piscinas de forma eficiente", "Exteriores", 50, Date.valueOf("2010-10-10")));
		assert daoModule.getItemById("x") == null;
	}
	
	// TODO D02P05
}