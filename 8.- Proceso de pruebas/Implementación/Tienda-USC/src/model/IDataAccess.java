package model;


public interface IDataAccess {
	int JDBC_FACTORY = 1;

	static DAOFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
			case IDataAccess.JDBC_FACTORY:
				return new DAOFactoryJDBC();
			default:
				throw new IllegalArgumentException();
		}
	}
}