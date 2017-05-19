package DAO;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import model.Item;
import model.Line;
import model.Order;
import model.User;

public class DAOModuleInsertOrderTest {
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
	@Ignore("El ID de Order debe ser String y es int, no se puede realizar la prueba")
	public void testD02P04() {
		User user = new User("U-abcde-000", "Usuario", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
		Order order = new Order("x", Order.WAITTING, user, "U-eftgk-234");
		order.addLine(new Line(2, 19.99f, new Item("I-abcde-000", "producto", "Descripción del producto", "Cosas", 50, Date.valueOf("2000-01-01"))));
		
		assertFalse(daoModule.insertOrder(order));
		assertFalse(daoModule.getHistorialUser(user).contains(order));
	}
	
	@Test
	@Ignore("El ID de Order debe ser String y es int, no se puede realizar la prueba")
	public void testinsertOrderC1() {
		User user = new User("U-aaaaa-000", "Usuario", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
		Order order = new Order("O-aaaaa-000", Order.WAITTING, user, "U-eftgk-234");
		order.addLine(new Line(2, 19.99f, new Item("I-aaaaa-000", "producto", "Descripción del producto", "Cosas", 50, Date.valueOf("2000-01-01"))));
		
		assert daoModule.insertOrder(order);
		assert daoModule.getHistorialUser(user).contains(order);
	}
	
	@Test
	@Ignore("El ID de Order debe ser String y es int, no se puede realizar la prueba")
	public void testinsertOrderC2() {
		User user = new User("U-aaaaa-999", "Usuario", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
		Order order = new Order("O-aaaaa-000", Order.WAITTING, user, "U-eftgk-234");
		order.addLine(new Line(2, 19.99f, new Item("I-aaaaa-000", "producto", "Descripción del producto", "Cosas", 50, Date.valueOf("2000-01-01"))));
		
		assertNull(daoModule.isRegistered(user.getID_User()));
		assertFalse(daoModule.insertOrder(order));
		assertFalse(daoModule.getHistorialUser(user).contains(order));
	}
	
	@Test
	@Ignore("El ID de Order debe ser String y es int, no se puede realizar la prueba")
	public void testinsertOrderC3() {
		User user = new User("U-aaaaa-000", "Usuario", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
		Order order = new Order("O-aaaaa-000", Order.WAITTING, user, "U-eftgk-234");
		
		assertFalse(daoModule.insertOrder(order));
		assertFalse(daoModule.getHistorialUser(user).contains(order));
	}
	
	@Test
	@Ignore("El ID de Order debe ser String y es int, no se puede realizar la prueba")
	public void testinsertOrderC4() {
		User user = new User("U-aaaaa-000", "Usuario", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
		Order order = new Order("O-aaaaa-000", Order.WAITTING, user, "U-eftgk-234");
		order.addLine(new Line(2, 19.99f, new Item("I-aaaaa-999", "producto", "Descripción del producto", "Cosas", 50, Date.valueOf("2000-01-01"))));
		
		assertNull(daoModule.getItemById("I-aaaaa-999"));
		assertFalse(daoModule.insertOrder(order));
		assertFalse(daoModule.getHistorialUser(user).contains(order));
	}
}
