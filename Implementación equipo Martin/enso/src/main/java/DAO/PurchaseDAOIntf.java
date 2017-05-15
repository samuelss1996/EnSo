package DAO;

import java.util.ArrayList;

import model.*;

public interface PurchaseDAOIntf {
	
	public boolean insertOrder(Order order);     
	public boolean validateOrder(Purchase purchase, boolean decision);
	public ArrayList<Order> getHistorialUser(User user);  
	public Purchase getPurchase(Order order);
}
