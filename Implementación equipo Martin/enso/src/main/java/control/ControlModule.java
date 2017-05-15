package control;

import java.util.ArrayList;
import DAO.DAOInterface;
import DAO.DAOModule;
import imports.ImportsInterface;
import imports.ImportsModule;
import model.Item;
import model.Order;
import model.Purchase;
import model.User;
import statistics.StatisticsInterface;
import statistics.StatisticsModule;

public class ControlModule implements ControlInterface{
	
	private DAOInterface dao;
	private StatisticsInterface statistics;
	private ImportsInterface imports;
	
	public ControlModule(String sCHEMA, String dB_URL, String uSER, String pASS) {
		dao = new DAOModule(sCHEMA,dB_URL,uSER,pASS);
		statistics = new StatisticsModule(sCHEMA,dB_URL,uSER,pASS);
		imports = new ImportsModule(sCHEMA,dB_URL,uSER,pASS);
	}
	
	@Override
	public int importarUsuarios(String path) {
		
		return imports.importarUsuarios(path);
		
	}

	@Override
	public int importarProducto(String path) {

		return imports.importarProducto(path);
		
	}

	@Override
	public int importarCompra(String path) {

		return imports.importarCompra(path);
		
	}

	@Override
	public boolean insertUser(User user) {

		return dao.insertUser(user);
		
	}

	@Override
	public boolean insertItem(Item item) {

		return dao.insertItem(item);
		
	}

	@Override
	public boolean insertarVenta(Purchase venta) {

		return dao.validateOrder(venta, true);
		
	}

	@Override
	public User isRegistered(String ID_User) {
		//
		return dao.isRegistered(ID_User);
		
	}

	@Override
	public ArrayList<Purchase> getPurchaseHistorial(User user) {

		return dao.getPurchaseHistorial(user);
		
	}

	@Override
	public int[] getValoresBrutos(int dias) {
		//
		return statistics.getValoresBrutos(dias);
		
		
	}

	@Override
	public float getMedias(int dias) {
		//
		return statistics.getMedias(dias);
	}

	@Override
	public int[] getHistogramas(int mode) {

		return statistics.getHistogramas(mode);
	}

	@Override
	public float[] getPorcentajes(int mode) {

		return statistics.getPorcentajes(mode);
		
	}

	@Override
	public Item getItemById(String item) {
		return dao.getItemById(item);
	}

	@Override
	public boolean insertOrder(Order order) {
		
		return dao.insertOrder(order);
		
	}

	@Override
	public User logIn(String user, String passwd) {
		return dao.isRegistered(user);
	}

}
