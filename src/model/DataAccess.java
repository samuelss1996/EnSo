package model;


public class DataAccess implements IDataAccess {
	public DAOFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
			case IDataAccess.JDBC_FACTORY:
				return new DAOFactoryJDBC();
			default:
				return null;
		}
	}
}
