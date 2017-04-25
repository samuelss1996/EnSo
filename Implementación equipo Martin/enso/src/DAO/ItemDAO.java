package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Item;

public class ItemDAO extends SuperDAO implements ItemDAOIntf{
    
	private PreparedStatement stm;
    private ResultSet rs;
    
    public ItemDAO(String sCHEMA, String dB_URL, String uSER, String pASS){
        super(sCHEMA, dB_URL, uSER, pASS);
    }

    
    
    /*
     * 
     * ID_Item VARCHAR(11) PRIMARY KEY,
	nombre VARCHAR(30) NOT NULL,
	descripcion VARCHAR(100) NOT NULL,
    categoria VARCHAR(20) NOT NULL,
    stock int NOT NULL,
    fecha_disp TIMESTAMP NOT NULL
     * */
    
	@Override
	public boolean insertItem(Item item) {
		int r = -1;
		
		try {
	        openConection();
	        String selectSQL = " INSERT INTO Item (ID_Item, nombre, descripcion, categoria, stock, fecha_disp) values (? ,?, ?, ?, ?, ?)";
		    stm = connection.prepareStatement(selectSQL);
		    stm.setString(1, item.getItemRef());
		    stm.setString(2, item.getName());
		    stm.setString(3, item.getDescription());
		    stm.setString(4, item.getCategory());
		    stm.setInt(5, item.getStock());
		    stm.setDate(6, item.getAvailableDate());
		    
		    r = stm.executeUpdate();
		    closeConnection();
		} catch (SQLException | ClassNotFoundException ex) {
		   System.out.println(ex.getMessage());
		}	
		
        if(  r > 0){
        	return true;
        }else{
        	return false;
        }
	}

	@Override
	public Item getItemById(String ID_Item) {
		Item item = null;
        try {
            openConection();
            String selectSQL = "SELECT ID_Item, nombre, descripcion, categoria, stock, fecha_disp FROM Item where ID_Item like ?";
            stm = connection.prepareStatement(selectSQL);
            stm.setString(1, ID_Item);
            rs = stm.executeQuery();
            if(rs.next()){                
                item = new Item(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getDate(6));
            }
            closeConnection();
                    
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return item;
	}

	@Override
	public boolean updateItem(Item item) {
		int r = -1;
		try {
            openConection();
            String updateSQL = "UPDATE Item SET"
            		+ " nombre = ?,descripcion = ?, categoria = ?, stock = ?, fecha_disp = ?"
            		+ " where ID_Item like ?";
            stm = connection.prepareStatement(updateSQL);
            
            stm.setString(1, item.getName());
            stm.setString(2, item.getDescription());
            stm.setString(3, item.getCategory());
            stm.setInt(4, item.getStock());
            stm.setDate(5, item.getAvailableDate());
            
            stm.setString(6, item.getItemRef());   
            
            r = stm.executeUpdate();
            closeConnection();
           
                    
	    } catch (SQLException | ClassNotFoundException ex) {
	        System.out.println(ex.getMessage());
	    }
		if(  r > 0){
		 	return true;
		}else{
			return false;
		}
	}

}
