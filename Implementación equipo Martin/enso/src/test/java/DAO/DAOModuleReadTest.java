package DAO;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Item;
import model.Line;
import model.Order;
import model.User;

public class DAOModuleReadTest {
	private static final String DB_SCHEMA = "ensop8";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/";
	private static final String DB_USER = "enso";
	private static final String DB_PASSWORD = "enso";
	
	private static DAOModule daoModule;
	private static Order order;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		daoModule = new DAOModule(DB_SCHEMA, DB_URL, DB_USER, DB_PASSWORD);
		
		order = new Order(0, Order.ACCEPTED, new User("U-abcde-000", "Manuel", "Soutoullo", "77013889E", Date.valueOf("2010-10-10"), User.ALUMN), "U-EFTGK-234");
		order.addLine(new Line(2, 19.99f, new Item("I-abcde-000", "Robot limpiapiscinas", "Limpia piscinas", "Exteriores", 50, Date.valueOf("2010-10-10"))));
		daoModule.insertOrder(order);
	}

	@Test
	public void testD04P01() {
		ArrayList<Order> history = daoModule.getHistorialUser(new User("U-abcde-000", "Manuel", "Soutoullo", "77013889E", Date.valueOf("2010-10-10"), User.ALUMN));
		assertEquals(1, history.size());
		assertEquals(order, history.get(0));
	}
	
	@Test
	public void testD04P02() {
		ArrayList<Order> history = daoModule.getHistorialUser(new User("U-a-000", "Manuel", "Soutoullo", "77013889E", Date.valueOf("2010-10-10"), User.ALUMN));	
		assertTrue(history.isEmpty());
	}
	
	@Test
	public void testD04P03() {
		ArrayList<Order> history = daoModule.getHistorialUser(new User("U-abcde-999", "Manuel", "Soutoullo", "77013889E", Date.valueOf("2010-10-10"), User.ALUMN));
		assertTrue(history.isEmpty());
	}
	
	@Test
	public void testD04P04() {
		ArrayList<Order> history = daoModule.getHistorialUser(new User("U-abcde-123", "Manuel", "Soutoullo", "77013889E", Date.valueOf("2010-10-10"), User.ALUMN));
		assertTrue(history.isEmpty());
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