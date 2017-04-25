package DAO;

import java.util.ArrayList;

import model.*;

public class DAOModule implements DAOInterface {

	private UserDAOIntf userDAO;
	private ItemDAOIntf itemDAO;
	private PurchaseDAOIntf purchaseDAO;
	
	public DAOModule(String sCHEMA, String dB_URL, String uSER, String pASS){
		userDAO = new UserDAO(sCHEMA,dB_URL,uSER,pASS);
		itemDAO = new ItemDAO(sCHEMA,dB_URL,uSER,pASS);
		purchaseDAO = new PurchaseDAO(sCHEMA,dB_URL,uSER,pASS);
	}
	
	//Users
	@Override
	public boolean insertUser(User user) {
		return userDAO.insertUser(user);
	}

	@Override
	public boolean modUsuario(User user) {
		return userDAO.modUsuario(user);
	}

	@Override
	public User isRegistered(String ID) {
		return userDAO.isRegistered(ID);
	}

	@Override
	public ArrayList<User> getAllUsers() {
		return userDAO.getAllUsers();
	}
	
	//Items
	@Override
	public boolean insertItem(Item item) {
		return itemDAO.insertItem(item);
	}
	@Override
	public Item getItemById(String item) {
		return itemDAO.getItemById(item);
	}
	@Override
	public boolean updateItem(Item item) {
		return itemDAO.updateItem(item);
	}	
	
	
	//Purchases
	@Override
	public ArrayList<Order> getHistorialUser(User user) {
		return purchaseDAO.getHistorialUser(user);
	}
	@Override
	public boolean insertOrder(Order order) {
		return purchaseDAO.insertOrder(order);
	}
	@Override
	public boolean validateOrder(Purchase purchase, boolean decision) {
		return purchaseDAO.validateOrder(purchase, decision);
		
	}

	@Override
	public Purchase getPurchase(Order order) {		
		return purchaseDAO.getPurchase(order);
	}

	@Override
	public ArrayList<Purchase> getPurchaseHistorial(User user) {
		ArrayList<Purchase> purchases = new ArrayList<>();
		
		for(Order o:purchaseDAO.getHistorialUser(user)){
			if(o.getState().equals(Order.ACCEPTED)){
				purchases.add(purchaseDAO.getPurchase(o));
			}
		}		
		return purchases;
	}
	
}
