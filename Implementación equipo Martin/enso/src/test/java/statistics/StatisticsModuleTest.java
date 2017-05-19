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
	public void testgetValoresBrutosC1() {
		
		daoModule.insertUser(new User("U-AAAAA-001", "Usuaria", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID));
		Order order = new Order("P-AAAAA-000", Order.ACCEPTED, )
		Purchase purchase = new Purchase("V-AAAAA-001", order, new Date(LocalDate.now().toEpochDay()));
				
//				User user = new User("U-aaaaa-000", "Usuario", "Usuario1", "12213428H", Date.valueOf("2017-04-24"), User.PID);
//		Order order = new Order("O-aaaaa-000", Order.WAITTING, user, "U-eftgk-234");
//		Item item = new Item("I-aaaaa-000", "producto", "Descripcion del producto", "cosas", 50, Date.valueOf("1970-01-01"));
//		Line line = new Line(2, 19.99f, item);
		
		
		testClass.getValoresBrutos(1);
	}

}
