package model;


import model.data.Application;
import model.data.Center;
import model.data.User;

import java.util.List;

public interface IDAOUser {
	void addUser(User user);

	void updateUser(User user);

	void deregisterUser(int userId, String password);

	User fetchUser(int userId);

	List<User> queryUser(String username);

	Application getApplication();

	Center getCenter();
}
