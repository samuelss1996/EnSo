package DAO;

import model.Item;

public interface ItemDAOIntf {

	//C
    public boolean insertItem(Item item);
    
    //R
    public Item getItemById(String item);
    
    //U
    public boolean updateItem(Item item); 

}
