package imports;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import DAO.DAOModule;
import DAO.UserDAO;
import model.Item;

public class ImportsModuleDependentsTest {

	static ImportsModule testClass;
	static UserDAO userDAO;
	static DAOModule daoModule;
	
	@BeforeClass
	public static void loadModule() {
		String SCHEMA = "ensop8";
	    String DB_URL = "jdbc:mysql://localhost:3306/";
	
	   //  Database credentials
	    String USER = "enso";
	    String PASS = "enso";
		testClass = new ImportsModule(SCHEMA, DB_URL, USER, PASS);
		userDAO = new UserDAO(SCHEMA, DB_URL, USER, PASS);
		daoModule = new DAOModule(SCHEMA, DB_URL, USER, PASS);
	}
	
	@Test
	public void testI01P12() throws IOException {
		//U-aaaaa-000 está insertado por ImportsModuleTest
		
		Files.write(Paths.get("test.txt"), "U; U-aaaaa-000; 10/10/2010; Samuel; Soutullo Sobral; 77013889E".getBytes());
		
		assertEquals(0, testClass.importarUsuarios("test.txt"));
	}
	
	@Test
	public void testI01P13() throws IOException {
		
		//El usuario e item no existen
		assertNull(daoModule.getItemById("I-trewq-000"));
		assertNull(userDAO.isRegistered("U-trewq-000"));
		
		Files.write(Paths.get("test.txt"), "V; V-aaaaa-000; 10/10/2010; U-trewq-000; I-trewq-000; 1; 1.53".getBytes());
		
		assertEquals(0, testClass.importarCompra("test.txt"));
	}
	
	@Test
	public void testI01P14() throws IOException {
		
		
		daoModule.insertItem(new Item("I-abcde-001", "Robot limpiapiscinas", "Limpia piscinas", "Exteriores", 50, Date.valueOf("2010-10-10")));
		
		Files.write(Paths.get("test.txt"), ("V; V-aaaaa-000; 10/10/2010; U-aaaaa-000; I-abcde-000; 1; 1.53\n"+
											"V; V-aaaaa-000; 10/10/2010; U-aaaaa-000; I-abcde-001; 1; 2.64").getBytes());
		
		assertEquals(2, testClass.importarCompra("test.txt"));
	}
}
