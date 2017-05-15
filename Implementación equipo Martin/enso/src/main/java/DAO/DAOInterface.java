package DAO;

import java.util.ArrayList;

import model.Purchase;
import model.User;

public interface DAOInterface extends UserDAOIntf, ItemDAOIntf, PurchaseDAOIntf{

	public ArrayList<Purchase> getPurchaseHistorial(User user);
	
}
