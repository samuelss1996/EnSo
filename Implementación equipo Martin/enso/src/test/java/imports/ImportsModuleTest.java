package imports;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import junit.framework.TestCase;

public class ImportsModuleTest extends TestCase {

	public void testI01P01() throws IOException {
		Files.write(Paths.get("test.txt"), "dd".getBytes());
	}
	
	
	public void testImportarUsuarios() {
		fail("Not yet implemented");
	}

	public void testImportarCompra() {
		fail("Not yet implemented");
	}

}
