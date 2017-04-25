package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.*;

public class PurchaseDAO extends SuperDAO implements PurchaseDAOIntf{
    
	private PreparedStatement stm;
    private ResultSet rs;
    
    public PurchaseDAO(String sCHEMA, String dB_URL, String uSER, String pASS){
        super(sCHEMA, dB_URL, uSER, pASS);
    }

	
	
	@Override
	public boolean insertOrder(Order order) {
		int r = 0;
		String insertOrderSQL = " INSERT INTO Pedido (ID_Pedido, estado, ID_autor) values (? ,?, ?)";
        String insertLineSQL = " INSERT INTO LineaCompra (ID_Item, ID_Pedido, precio, cantidad) values (? ,?, ? ,?)";
        try {
            openConection();
            
            stm = connection.prepareStatement(insertOrderSQL);
            stm.setInt(1, order.getID_Order());
            stm.setString(2, Order.WAITTING);
            stm.setString(3, order.getUser().getID_User());
            
            r += stm.executeUpdate();
            
            for(Line l: order.getLines()) {
            	stm = connection.prepareStatement(insertLineSQL);
                stm.setString(1, l.getItem().getItemRef());
                stm.setInt(2, order.getID_Order());
                stm.setFloat(3, l.getPrice());
                stm.setInt(4, l.getQuantity());
                
                r += stm.executeUpdate(); 
            }
            
           
            
            
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
	
	/*TODO 
	 * Reducir stock. 
	 * Añadir Precio actual al item 
	 * Check rol ADMIN 
	 */
	
	@Override
	public boolean validateOrder(Purchase purchase, boolean decision) {
		int r = 0;
		PreparedStatement prOrder;
		PreparedStatement prPurchase;
        try {
        	
            openConection();
            String updateOrderSQL = "UPDATE Pedido SET estado = ? where ID_Pedido = ?";
            
            String insertPurchaseSQL = " INSERT INTO Compra (ID_Compra, ID_Pedido, fecha, descuento) values (? ,? , ?, ?)";
            
            
            prPurchase = connection.prepareStatement(insertPurchaseSQL);
            prPurchase.setString(1, purchase.getID_Purchase());
            prPurchase.setInt(2, purchase.getOrder().getID_Order());
            prPurchase.setDate(3, purchase.getDate());
            prPurchase.setFloat(4, purchase.getDiscount());
            
            r += prPurchase.executeUpdate();
            
            prOrder = connection.prepareStatement(updateOrderSQL);
            String state = Order.DENEGATED;
            if(decision){
            	state = Order.ACCEPTED;
            }
            prOrder.setString(1, state);
            prOrder.setInt(2, purchase.getOrder().getID_Order());

            System.out.println("---"+prOrder);
            r += prOrder.executeUpdate();
            
            
            
            
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
	public ArrayList<Order> getHistorialUser(User user) {
		
		ArrayList<Order> orders = new ArrayList<>();
        try {
            openConection();
            String selectOrderSQL = "SELECT ID_Pedido, estado, ID_autor,ID_validador FROM Pedido where ID_autor like ?";
            //TODO String selectLineSQL = "SELECT ID_Pedido, estado, ID_autor,ID_validador FROM Pedido where ID_autor like ?";
            stm = connection.prepareStatement(selectOrderSQL);
            stm.setString(1, user.getID_User());
            rs = stm.executeQuery();
            Order order;
            if(rs.next()){
            	order = new Order(rs.getInt(1),rs.getString(2),user,rs.getString(4));
            	orders.add(order);
            }
            closeConnection();
                    
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return orders;
	}



	@Override
	public Purchase getPurchase(Order order) {
		
		Purchase purchase = null;
        try {
            openConection();
            String selectSQL = "SELECT ID_Compra, fecha, descuento FROM Compra where ID_Pedido like ?";
            stm = connection.prepareStatement(selectSQL);
            stm.setInt(1, order.getID_Order());
            rs = stm.executeQuery();
            if(rs.next()){                
            	purchase = new Purchase(rs.getString(1), order, rs.getDate(2), rs.getFloat(3));
            }
            closeConnection();
                    
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return purchase;
		
	}
	
}
