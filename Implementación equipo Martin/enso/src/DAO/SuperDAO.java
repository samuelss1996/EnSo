package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
* @author Xhark
*/ 
public abstract class SuperDAO {    
   // JDBC driver name and database URL
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    String SCHEMA = "ENSOP8";
    String DB_URL = "jdbc:mysql://178.62.24.177/";

   //  Database credentials
    String USER = "ENSO";
    String PASS = "enso";

   //Objet conection
   Connection connection;
   
   
    
   public SuperDAO(String sCHEMA, String dB_URL, String uSER, String pASS) {
		super();
		SCHEMA = sCHEMA;
		DB_URL = dB_URL;
		USER = uSER;
		PASS = pASS;
	}

public void openConection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(DB_URL+SCHEMA,USER, PASS);        
   }
   
   public void closeConnection()throws SQLException{
       connection.close();
   }  
   
   
   
}