package model;


import model.data.Application;
import model.data.Center;
import model.data.User;

import java.util.List;

public class JDBCUserDAO implements IDAOUser {
    @Override
    public void addUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deregisterUser(int userId, String password) {

    }

    @Override
    public User fetchUser(int userId) {
        return null;
    }

    @Override
    public List<User> queryUser(String username) {
        return null;
    }

    @Override
    public Application getApplication() {
        return null;
    }

    @Override
    public Center getCenter() {
        return null;
    }
}
