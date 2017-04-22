package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAOFactoryJDBC extends DAOFactory {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/enso";

    public static Connection createConnection() {
        try {
            Class.forName(DRIVER).newInstance();
            return DriverManager.getConnection(DB_URL, "enso", "enso");
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

	public IDAOUser getUserDAO() {
		return new JDBCUserDAO();
	}
	
	public IDAOProduct getProductDAO() {
		return new JDBCProductDAO();
	}
	
	public IDAOSell getSellDAO() {
		return new JDBCSellDAO();
	}
	
	public IDAOImport getImportDAO() { return new JDBCImportDAO(); }
}
