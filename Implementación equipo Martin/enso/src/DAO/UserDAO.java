package DAO;

import java.sql.*;
import java.util.ArrayList;

import model.User;

public class UserDAO extends SuperDAO implements UserDAOIntf{
    
	private PreparedStatement stm;
    private ResultSet rs;
    
    public UserDAO(String sCHEMA, String dB_URL, String uSER, String pASS){
        super(sCHEMA, dB_URL, uSER, pASS);
    }

	@Override
	public boolean insertUser(User user) {
		int r = -1;
        try {
            openConection();
            String selectSQL = " INSERT INTO Usuario (ID_User, nombre, apellidos, NIF, fecha, tipo) values (? ,?, ?, ?, ?, ?)";
            stm = connection.prepareStatement(selectSQL);
            stm.setString(1, user.getID_User());
            stm.setString(2, user.getName());
            stm.setString(3, user.getSurname());
            stm.setString(4, user.getNIF());
            stm.setDate(5, user.getDate());
            stm.setString(6, user.getTipe().toString());
            
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
	public User isRegistered(String ID_User) {
		User user = null;
        try {
            openConection();
            String selectSQL = "SELECT ID_User, nombre, apellidos, NIF, fecha, tipo FROM Usuario where ID_User like ?";
            stm = connection.prepareStatement(selectSQL);
            stm.setString(1, ID_User);
            rs = stm.executeQuery();
            if(rs.next()){                
            	
                user = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6));
            }
            closeConnection();
                    
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return user;
	}

	@Override
	public boolean modUsuario(User user) {
		try {
            openConection();
            String updateSQL = "UPDATE Usuario SET"
            		+ " nombre = ?,apellidos = ?, NIF = ?, fecha = ?, tipo = ?"
            		+ " where ID_User like ?";
            stm = connection.prepareStatement(updateSQL);
            
            stm.setString(1, user.getName());
            stm.setString(2, user.getSurname());
            stm.setString(3, user.getNIF());
            stm.setDate(4, user.getDate());
            stm.setString(5, user.getTipe());
            
            stm.setString(6, user.getID_User());   
            
            int r = stm.executeUpdate();
            closeConnection();
            if(  r > 0){
            	return true;
            }else{
            	return false;
            }
                    
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
		return false;
	}

	@Override
	public ArrayList<User> getAllUsers() {
		
		ArrayList<User> usuarios = new ArrayList<>();
		
        try {
            openConection();
            String selectSQL = "SELECT * FROM Usuario";
            stm = connection.prepareStatement(selectSQL);
            rs = stm.executeQuery();
            while(rs.next()){
            	usuarios.add(new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6)));
            }
            closeConnection();
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return usuarios;
	}

}
