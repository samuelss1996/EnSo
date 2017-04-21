package model;


public abstract class DAOFactory {
	public abstract IDAOUser getUserDAO();
	public abstract IDAOProduct getProductDAO();
	public abstract IDAOSell getSellDAO();
	public abstract IDAOImport getImportDAO();
}
