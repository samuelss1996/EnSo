package DAO;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import model.Item;
import model.Line;
import model.Order;
import model.Purchase;
import model.User;

public class DAOModuleOrderValidationDependentsTest {
	
static DAOModule testClass;
	
	@BeforeClass
	public static void loadModule() {
		String SCHEMA = "ensop8";
	    String DB_URL = "jdbc:mysql://localhost:3306/";

	   //  Database credentials
	    String USER = "enso";
	    String PASS = "enso";
		testClass = new DAOModule(SCHEMA, DB_URL, USER, PASS);
	}

	@Test
	@Ignore("Order no compila porque solicita un int, pero en la base de datos lo inserta sobre un string")
	public void testValidateOrderC4() {
		// La venta es insertada previamente en testValidateOrderC1
		User user = new User("U-aaaaa-000", "Usuario", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
		Order order = new Order("O-aaaaa-000", Order.WAITTING, user, "U-eftgk-234");
		Item item = new Item("I-aaaaa-000", "producto", "Descripcion del producto", "cosas", 50, Date.valueOf("2000-01-01"));
		Line line = new Line(2, 19.99f, item);
		order.addLine(line);
		
		Purchase purchase = new Purchase("V-aaaaa-000", order, Date.valueOf("2017-05-04"), 0.2f);
		
		assertFalse(testClass.validateOrder(purchase, true));
	}

}
