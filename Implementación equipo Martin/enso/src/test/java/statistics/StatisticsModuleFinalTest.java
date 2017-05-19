package statistics;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;

import DAO.DAOModule;
import model.Item;
import model.Line;
import model.Order;
import model.Purchase;
import model.User;

public class StatisticsModuleFinalTest {

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
	public void testgetValoresBrutosC5_4() {
		User user0 = new User("U-FFFFF-000", "Usuario", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
		User user1 = new User("U-FFFFF-001", "Usuaria", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
		User user2 = new User("U-FFFFF-002", "Usuarioa", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
		User user3 = new User("U-FFFFF-003", "Usuarix", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
		User user4 = new User("U-FFFFF-004", "Usuarie", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
		
		//Ventas user1
		Order order1 = new Order(0, Order.ACCEPTED, user1, "U-EFTGK-234");
		Purchase purchase1 = new Purchase("V-FFFFF-000", order1, new Date(LocalDate.now().minusDays(1).toEpochDay()), 0.0f);
		
		//Ventas user2
		Order order2 = new Order(1, Order.ACCEPTED, user2, "U-EFTGK-234");
		Item item = new Item("I-FFFFF-000", "producto", "Descripcion del producto", "Cosas", 50, Date.valueOf("1970-01-01"));
		order2.addLine(new Line(2, 19.99f, item));
		Purchase purchase2 = new Purchase("V-FFFFF-001", order2, new Date(LocalDate.now().minusDays(1).toEpochDay()), 0.0f);
		
		Order order2a = new Order(2, Order.ACCEPTED, user2, "U-EFTGK-234");
		order2a.addLine(new Line(2, 19.99f, item));
		Purchase purchase2a = new Purchase("V-FFFFF-002", order2a, new Date(LocalDate.now().minusDays(1).toEpochDay()), 0.0f);
		
		//Ventas user3
		Order order3 = new Order(3, Order.ACCEPTED, user3, "U-EFTGK-234");
		order3.addLine(new Line(2, 19.99f, item));
		Purchase purchase3 = new Purchase("V-FFFFF-003", order3, new Date(LocalDate.now().minusDays(3).toEpochDay()), 0.0f);
		
		//Ventas user4
		Order order4 = new Order(4, Order.ACCEPTED, user4, "U-EFTGK-234");
		Purchase purchase4 = new Purchase("V-FFFFF-004", order4, new Date(LocalDate.now().minusDays(6).toEpochDay()), 0.0f);
		
		
		//Inserciones
		daoModule.insertUser(user0);
		daoModule.insertUser(user1);
		daoModule.insertUser(user2);
		daoModule.insertUser(user3);
		daoModule.insertUser(user4);
		
		daoModule.insertItem(item);
		
		daoModule.insertOrder(order1);
		daoModule.insertOrder(order2);
		daoModule.insertOrder(order2a);
		daoModule.insertOrder(order3);
		daoModule.insertOrder(order4);
		
		daoModule.validateOrder(purchase1, true);
		daoModule.validateOrder(purchase2, true);
		daoModule.validateOrder(purchase2a, true);
		daoModule.validateOrder(purchase3, true);
		daoModule.validateOrder(purchase4, true);
		
		assertArrayEquals(new int[]{0,1,0,3,0}, testClass.getValoresBrutos(5));
	}
	
	@Test
	public void testgetMediasC5() {
		User user0 = new User("U-qwqwq-000", "Usuario", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
		User user1 = new User("U-qwqwq-001", "Usuaria", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
		User user2 = new User("U-qwqwq-002", "Usuarioa", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
		User user3 = new User("U-qwqwq-003", "Usuarix", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
		User user4 = new User("U-qwqwq-004", "Usuarie", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
		
		//Ventas user1
		Order order1 = new Order(0, Order.ACCEPTED, user1, "U-EFTGK-234");
		Purchase purchase1 = new Purchase("V-qwqwq-000", order1, new Date(LocalDate.now().minusDays(1).toEpochDay()), 0.0f);
		
		//Ventas user2
		Order order2 = new Order(1, Order.ACCEPTED, user2, "U-EFTGK-234");
		Item item = new Item("I-qwqwq-000", "producto", "Descripcion del producto", "Cosas", 50, Date.valueOf("1970-01-01"));
		order2.addLine(new Line(2, 19.99f, item));
		Purchase purchase2 = new Purchase("V-qwqwq-001", order2, new Date(LocalDate.now().minusDays(1).toEpochDay()), 0.0f);
		
		Order order2a = new Order(2, Order.ACCEPTED, user2, "U-EFTGK-234");
		order2a.addLine(new Line(2, 19.99f, item));
		Purchase purchase2a = new Purchase("V-qwqwq-002", order2a, new Date(LocalDate.now().minusDays(1).toEpochDay()), 0.0f);
		
		//Ventas user3
		Order order3 = new Order(3, Order.ACCEPTED, user3, "U-EFTGK-234");
		order3.addLine(new Line(2, 19.99f, item));
		Purchase purchase3 = new Purchase("V-qwqwq-003", order3, new Date(LocalDate.now().minusDays(3).toEpochDay()), 0.0f);
		
		//Ventas user4
		Order order4 = new Order(4, Order.ACCEPTED, user4, "U-EFTGK-234");
		Purchase purchase4 = new Purchase("V-qwqwq-004", order4, new Date(LocalDate.now().minusDays(6).toEpochDay()), 0.0f);
		
		
		//Inserciones
		daoModule.insertUser(user0);
		daoModule.insertUser(user1);
		daoModule.insertUser(user2);
		daoModule.insertUser(user3);
		daoModule.insertUser(user4);
		
		daoModule.insertItem(item);
		
		daoModule.insertOrder(order1);
		daoModule.insertOrder(order2);
		daoModule.insertOrder(order2a);
		daoModule.insertOrder(order3);
		daoModule.insertOrder(order4);
		
		daoModule.validateOrder(purchase1, true);
		daoModule.validateOrder(purchase2, true);
		daoModule.validateOrder(purchase2a, true);
		daoModule.validateOrder(purchase3, true);
		daoModule.validateOrder(purchase4, true);
		
		assertEquals(0.8f, testClass.getMedias(5), 0.0001f);
	}
	
	
}