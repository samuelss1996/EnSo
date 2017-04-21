package model;


public interface IDataAccess {
	int JDBC_FACTORY = 1;
	DAOFactory getDAOFactory(int whichFatory);
}
