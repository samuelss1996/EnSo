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
	public void testgetValoresBrutosC1_4() {
		User user = new User("U-AAAAA-001", "Usuaria", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
		Order order = new Order(0, Order.ACCEPTED, user, "U-EFTGK-234");
		Item item = new Item("I-AAAAA-000", "producto", "Descripcion del producto", "Cosas", 50, Date.valueOf("1970-01-01"));
		order.addLine(new Line(2, 19.99f, item));
		Purchase purchase = new Purchase("V-AAAAA-001", order, new Date(LocalDate.now().toEpochDay()), 0.0f);
		
		daoModule.insertUser(user);
		daoModule.insertItem(item);
		daoModule.insertOrder(order);
		daoModule.validateOrder(purchase, true);
		
		assertArrayEquals(new int[]{1}, testClass.getValoresBrutos(1));
	}
	
	@Test
	public void testgetValoresBrutosC3() {
		assertArrayEquals(new int[0], testClass.getValoresBrutos(0));
	}
	
	@Test
	public void testgetValoresBrutosC4_2() {
		User user = new User("U-AAAAA-001", "Usuaria", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
		
		daoModule.insertUser(user);
		
		assertArrayEquals(new int[]{0}, testClass.getValoresBrutos(1));
	}
	
	@Test
	public void testgetValoresBrutosC5_4() {
		User user0 = new User("U-AAAAA-000", "Usuario", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
		User user1 = new User("U-AAAAA-001", "Usuaria", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
		User user2 = new User("U-AAAAA-002", "Usuarioa", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
		User user3 = new User("U-AAAAA-003", "Usuarix", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
		User user4 = new User("U-AAAAA-004", "Usuarie", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
		
		//Ventas user1
		Order order1 = new Order(0, Order.ACCEPTED, user1, "U-EFTGK-234");
		Purchase purchase1 = new Purchase("V-AAAAA-000", order1, new Date(LocalDate.now().minusDays(1).toEpochDay()), 0.0f);
		
		//Ventas user2
		Order order2 = new Order(1, Order.ACCEPTED, user2, "U-EFTGK-234");
		Item item = new Item("I-AAAAA-000", "producto", "Descripcion del producto", "Cosas", 50, Date.valueOf("1970-01-01"));
		order2.addLine(new Line(2, 19.99f, item));
		Purchase purchase2 = new Purchase("V-AAAAA-001", order2, new Date(LocalDate.now().minusDays(1).toEpochDay()), 0.0f);
		
		Order order2a = new Order(2, Order.ACCEPTED, user2, "U-EFTGK-234");
		order2a.addLine(new Line(2, 19.99f, item));
		Purchase purchase2a = new Purchase("V-AAAAA-002", order2a, new Date(LocalDate.now().minusDays(1).toEpochDay()), 0.0f);
		
		//Ventas user3
		Order order3 = new Order(3, Order.ACCEPTED, user3, "U-EFTGK-234");
		order3.addLine(new Line(2, 19.99f, item));
		Purchase purchase3 = new Purchase("V-AAAAA-003", order3, new Date(LocalDate.now().minusDays(3).toEpochDay()), 0.0f);
		
		//Ventas user4
		Order order4 = new Order(4, Order.ACCEPTED, user4, "U-EFTGK-234");
		Purchase purchase4 = new Purchase("V-AAAAA-004", order4, new Date(LocalDate.now().minusDays(6).toEpochDay()), 0.0f);
		
		
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
	public void testgetValoresBrutosC6_3() {
		User user = new User("U-AAAAA-001", "Usuaria", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
		Order order = new Order(0, Order.ACCEPTED, user, "U-EFTGK-234");
		Item item = new Item("I-AAAAA-000", "producto", "Descripcion del producto", "Cosas", 50, Date.valueOf("1970-01-01"));
		order.addLine(new Line(2, 19.99f, item));
		Purchase purchase = new Purchase("V-AAAAA-001", order, new Date(LocalDate.now().minusDays(2).toEpochDay()), 0.0f);
		
		daoModule.insertUser(user);
		daoModule.insertItem(item);
		daoModule.insertOrder(order);
		daoModule.validateOrder(purchase, true);
		
		assertArrayEquals(new int[]{0}, testClass.getValoresBrutos(1));
	}
	
	

}
