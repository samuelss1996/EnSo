
import control.ControlModule;
import model.Item;
import model.User;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) throws ParseException {
		System.out.println("------  DAO testing Main program  ------");
		String SCHEMA = "ensop8";
	    String DB_URL = "jdbc:mysql://localhost:3306/";

	   //  Database credentials
	    String USER = "enso";
	    String PASS = "enso";
	    
		ControlModule control = new ControlModule(SCHEMA, DB_URL, USER, PASS); 
		

		Date date = new Date();
		Item item = new Item("A1", "item01", "Un item.", "categoria", 5, new java.sql.Date(date.getTime()));
		control.insertItem(item);
		control.insertUser(new User("U-aaaaaa-000", "Samuel", "Soutullo Sobral", "59687435T", java.sql.Date.valueOf("2010-10-10"), User.ALUMN));
		System.out.println(control.getItemById("A1").getDescription());

	}

}
