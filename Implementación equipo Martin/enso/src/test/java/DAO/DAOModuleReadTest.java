package DAO;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Item;

public class DAOModuleReadTest {
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
	public void testD05P01() {
		Item item = daoModule.getItemById("I-abcde-000");
		
		assertEquals("I-abcde-000", item.getItemRef());
		assertEquals("Robot limpiapiscinas", item.getName());
		assertEquals("Limpia piscinas de forma eficiente", item.getDescription());
		assertEquals("Exteriores", item.getCategory());
		assertEquals(50, item.getStock());
		assertEquals(Date.valueOf("2010-10-10"), item.getAvailableDate());
	}
	
	@Test
	public void testD05P02() {
		assertNull(daoModule.getItemById("I-s-000"));
	}
	
	@Test
	public void testD05P03() {
		assertNull(daoModule.getItemById("I-abcde-999"));
	}
}