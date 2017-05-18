package imports;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.BeforeClass;
import org.junit.Test;

public class ImportsModuleTest {
	
	static ImportsModule testClass;
	
	@BeforeClass
	public static void loadModule() {
		String SCHEMA = "ensop8";
	    String DB_URL = "jdbc:mysql://localhost:3306/";

	   //  Database credentials
	    String USER = "enso";
	    String PASS = "enso";
		testClass = new ImportsModule(SCHEMA, DB_URL, USER, PASS);
	}

	@Test
	public void testI01P01() throws IOException {
		Files.write(Paths.get("test.txt"), "U; U-aaaaa-000; 10/10/2010; Samuel; Soutullo Sobral; 77013889E".getBytes());
		
		assertEquals(1, testClass.importarUsuarios("test.txt"));
	}
	
	@Test
	public void testI01P02() throws IOException {
		Files.write(Paths.get("test.txt"), "U; U-aaaaa-000; 10/10/2010; Samuel; Soutullo Sobral".getBytes());
		
		assertEquals(0, testClass.importarUsuarios("test.txt"));
	}
	
	@Test
	public void testI01P03() throws IOException {
		Files.write(Paths.get("test.txt"), "U; U-aaaaa-000; 10/10/2010; Samuel; Soutullo Sobral; 77013889E; asdfg".getBytes());
		
		assertEquals(0, testClass.importarUsuarios("test.txt"));
	}
	
	@Test
	public void testI01P04() throws IOException {
		Files.write(Paths.get("test.txt"), "".getBytes());
		
		assertEquals(0, testClass.importarUsuarios("test.txt"));
	}
	
	//TODO: El P04 aparece repetido. Actualizar con el documento
	
	@Test
	public void testI01P06() throws IOException {
		Files.write(Paths.get("test.txt"), "U; U-aaaaa-000; 10/10/2010; Samuel; Soutullo Sobral; 77013889E".getBytes());
		
		assertEquals(0, testClass.importarCompra("test.txt"));
	}
	
	@Test
	public void testI01P07() throws IOException {
		Files.write(Paths.get("test.txt"), "V; V-aaaaa-000; 10/10/2010; U-aaaaa-000; I-aaaaa-000; 1; 1.53".getBytes());
		
		assertEquals(1, testClass.importarCompra("test.txt"));
	}
	
	@Test
	public void testI01P08() throws IOException {
		Files.write(Paths.get("test.txt"), "U; U-aaaaa-000; 10/10/2010; ; Soutullo Sobral; 77013889E".getBytes());
		
		assertEquals(0, testClass.importarUsuarios("test.txt"));
	}
	
	@Test
	public void testI01P09() throws IOException {
		Files.write(Paths.get("test.txt"), "U; U-aaaaa-000; 10/10/2010; aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa ; Soutullo Sobral; 77013889E".getBytes());
		
		assertEquals(0, testClass.importarUsuarios("test.txt"));
	}
	
	@Test
	public void testI01P10() throws IOException {
		Files.write(Paths.get("test.txt"), "U; U-aaaaa-000; July 4, 2010; Samuel; Soutullo Sobral; 77013889E".getBytes());
		
		assertEquals(0, testClass.importarUsuarios("test.txt"));
	}
	
	@Test
	public void testI01P11() throws IOException {
		Files.write(Paths.get("test.txt"), "V; V-aaaaa-000; 10/10/2010; U-aaaaa-000; I-aaaaa-000; 1; 125ª".getBytes());
		
		assertEquals(0, testClass.importarCompra("test.txt"));
	}
	
	@Test
	public void testI01P12() throws IOException {
		//TODO: hacer que el usuario ya exista
		
		Files.write(Paths.get("test.txt"), "U; U-aaaaa-000; 10/10/2010; Samuel; Soutullo Sobral; 77013889E".getBytes());
		
		assertEquals(0, testClass.importarUsuarios("test.txt"));
	}
	
	@Test
	public void testI01P13() throws IOException {
		//TODO: hacer que el usuario y producto referenciados no existan
		
		Files.write(Paths.get("test.txt"), "V; V-aaaaa-000; 10/10/2010; U-aaaaa-000; I-aaaaa-000; 1; 1.53".getBytes());
		
		assertEquals(0, testClass.importarCompra("test.txt"));
	}
	
	@Test
	public void testI01P14() throws IOException {
		//TODO: Se presupone que la base de datos contiene el usuario U-aaaaaa-000 y los productos I-aaaaaa-000 y I-aaaaaa-001.
		
		Files.write(Paths.get("test.txt"), ("V; V-aaaaaa-000; 10/10/2010; U-aaaaaa-000; I-aaaaaa-000; 1; 1.53\n"+
											"V; V-aaaaaa-000; 10/10/2010; U-aaaaaa-000; I-aaaaaa-001; 1; 2.64").getBytes());
		
		assertEquals(2, testClass.importarCompra("test.txt"));
	}
	
	@Test
	public void testI02P02() {
		assertEquals(-1, testClass.importarUsuarios("!·$%&/()=?¿"));
		//TODO: imprime un mensaje de error por pantalla
	}
	
	@Test
	public void testI02P03() {
		assertEquals(-1, testClass.importarUsuarios("/home/usuario/ficheroInexistente.csv"));
	}

	
}
