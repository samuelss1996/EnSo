package DAO;

import java.util.ArrayList;

import model.User;

public interface UserDAOIntf  {
	//C
    public boolean insertUser(User user);
    
    //R
	public User isRegistered(String ID_User);
	
    //U
    public boolean modUsuario(User User);
    
    //R
    public ArrayList<User> getAllUsers();

}
