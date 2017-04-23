package model;


import model.data.Application;
import model.data.Center;
import model.data.User;

import java.util.List;

public interface IDAOUser {
	void addUser(User user);

	void updateUser(User user);

	void deregisterUser(String userId, String password);

	User fetchUser(String userId);

	List<User> queryUser(String username);

	List<Application> getApplications(String userID);

	Center getCenter(int id);
}
