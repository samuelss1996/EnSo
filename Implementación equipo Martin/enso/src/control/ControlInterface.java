package control;

import java.util.ArrayList;

import model.Item;
import model.Order;
import model.Purchase;
import model.User;

public interface ControlInterface {

	
	//Modulo Importar
	public int importarUsuarios(String path);
	public int importarProducto(String path);
	public int importarCompra(String path); 
	
	//Modulo DAO
	public boolean insertUser(User user);
    public boolean insertItem(Item item);
    public boolean insertarVenta(Purchase venta);
    public User isRegistered(String ID_User);
	public ArrayList<Purchase> getPurchaseHistorial(User user);

	
	//Modulo Estadistica
	public int[] getValoresBrutos(int dias);
	public float getMedias(int dias);
	public int[] getHistogramas(int mode);
	public float[] getPorcentajes(int mode);
	
	//Control
    public Item getItemById(String item);
	public boolean insertOrder(Order order);
	public User logIn(String user, String passwd);

	
}
