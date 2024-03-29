package statistics;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;

import DAO.DAOModule;
import model.Item;
import model.Line;
import model.Order;
import model.Purchase;
import model.User;

public class StatisticsModuleDBWithPurchaseTest {

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
		Item item = new Item("I-AAAAA-000", "producto", "Descripción del producto", "Cosas", 50, Date.valueOf("2000-01-01"));
		Order order = new Order(0, user);
		Purchase purchase = new Purchase("V-AAAAA-000", order, Date.valueOf(LocalDate.now()), 0.0f);
		
		order.addLine(new Line(2, 19.99f, item));
		
		daoModule.insertItem(item);
		daoModule.insertOrder(order);
		daoModule.validateOrder(purchase, true);
	}
	
	@Test
	public void testGetPorcentajesC1() {
		float[] expected = new float[Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH)];
		expected[29] = 1.0f;

		assertArrayEquals(expected, testClass.getPorcentajes(1), 0.01f);
	}
	
	@Test
	public void testGetPorcentajesC3() {
		User user = new User("U-AAAAA-001", "Usuaria", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
		Item item = new Item("I-AAAAA-000", "producto", "Descripción del producto", "Cosas", 50, Date.valueOf("2000-01-01"));
		Order order = new Order(1, user);
		Purchase purchase = new Purchase("V-AAPOR-001", order, Date.valueOf(LocalDate.now().minusDays(1)), 0.0f);
		
		order.addLine(new Line(2, 19.99f, item));
		
		daoModule.insertOrder(order);
		daoModule.validateOrder(purchase, true);
		
		float[] expected = new float[52];
		expected[51] = 100.0f;

		assertArrayEquals(expected, testClass.getPorcentajes(2), 0.01f);
	}
	
	@Test
	public void testgetValoresBrutosC6() {
		User user = new User("U-AAAAA-001", "Usuaria", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
		Order order = new Order(0, Order.ACCEPTED, user, "U-EFTGK-234");
		Item item = new Item("I-AAAAA-000", "producto", "Descripcion del producto", "Cosas", 50, Date.valueOf("2000-01-01"));
		order.addLine(new Line(2, 19.99f, item));
		Purchase purchase = new Purchase("V-AAAAA-001", order, Date.valueOf(LocalDate.now().minusDays(2)), 0.0f);
		
		daoModule.validateOrder(purchase, true);
		
		assertArrayEquals(new int[]{0}, testClass.getValoresBrutos(1));
	}
	
	@Test
	public void testgetMediasC1() {
		assertEquals(1.0f, testClass.getMedias(1), 0.00001f);
	}
	
	@Test
	public void testgetMediasC6() {
		User user = new User("U-AAAAA-001", "Usuaria", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
		Order order = new Order(0, Order.ACCEPTED, user, "U-EFTGK-234");
		Item item = new Item("I-AAAAA-000", "producto", "Descripcion del producto", "Cosas", 50, Date.valueOf("2000-01-01"));
		order.addLine(new Line(2, 19.99f, item));
		Purchase purchase = new Purchase("V-AAAAA-001", order, Date.valueOf(LocalDate.now().minusDays(2)), 0.0f);
		
		daoModule.validateOrder(purchase, true);
		
		assertEquals(0.0f, testClass.getMedias(1), 0.00001f);
	}
}