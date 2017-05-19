package statistics;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;

import DAO.DAOModule;
import imports.ImportsModule;
import model.Item;
import model.Line;
import model.Order;
import model.Purchase;
import model.User;

// TODO cosas de caja negra
public class StatisticsModuleTest {
	
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
	public void testgetValoresBrutosC1() {
		User user = new User("U-AAAAA-001", "Usuaria", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
		Order order = new Order(0, Order.ACCEPTED, user, "U-EFTGK-234");
		Item item = new Item("I-AAAAA-000", "producto", "Descripcion del producto", "Cosas", 50, Date.valueOf("1970-01-01"));
		order.addLine(new Line(2, 19.99f, item));
		Purchase purchase = new Purchase("V-AAAAA-001", order, new Date(LocalDate.now().toEpochDay()), 0.0f);
	
		daoModule.validateOrder(purchase, true);
		
		assertArrayEquals(new int[]{1}, testClass.getValoresBrutos(1));
	}
	
	@Test
	public void testgetValoresBrutosC3() {
		assertArrayEquals(new int[0], testClass.getValoresBrutos(0));
	}	
	
	@Test
	public void testgetMediasC3() {
		assertEquals(0.0f, testClass.getMedias(0), 0.00001f);
	}
}