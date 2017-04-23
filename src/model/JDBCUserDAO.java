package model;


import model.data.Application;
import model.data.Center;
import model.data.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCUserDAO implements IDAOUser {
    @Override
    public void addUser(User user) { //TODO adaptar teniendo en cuenta que desde el archivo no se pasan todos los datos
         try (Connection connection = DAOFactoryJDBC.createConnection()) {
             try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT into USER (id, idCenter, firstName, lastName, email, nif, type) values (?, ?, ?, ?, ?, ?, ?)")) {
                 preparedStatement.setString(1, user.getId());
                 preparedStatement.setInt(2, user.getCenter());
                 preparedStatement.setString(3, user.getFirstName());
                 preparedStatement.setString(4, user.getLastName());
                 preparedStatement.setString(5, user.getEmail());
                 preparedStatement.setString(6, user.getNIF());
                 preparedStatement.setString(7, user.getTypeUser());

                 preparedStatement.executeUpdate();
                 //TODO: manage id collision.
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
    }

    @Override
    public void updateUser(User user) {
        try (Connection connection = DAOFactoryJDBC.createConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE user SET idCenter = ?, " +
                                                                                    "firstName = ?, " +
                                                                                    "lastName = ?, " +
                                                                                    "email = ?, " +
                                                                                    "nif = ?, " +
                                                                                    "type = ? " +
                                                                                    "WHERE id = ?")) {
                preparedStatement.setInt(1, user.getCenter());
                preparedStatement.setString(2, user.getFirstName());
                preparedStatement.setString(3, user.getLastName());
                preparedStatement.setString(4, user.getEmail());
                preparedStatement.setString(5, user.getNIF());
                preparedStatement.setString(6, user.getTypeUser());
                preparedStatement.setString(7, user.getId());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deregisterUser(String userId, String password) {
        //TODO: password no se usa
        try (Connection connection = DAOFactoryJDBC.createConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM user WHERE id = ?")) {
                preparedStatement.setString(1, userId);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User fetchUser(String userId) {
        try (Connection connection = DAOFactoryJDBC.createConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE id = ?")) {
                preparedStatement.setString(1, userId);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return new User(resultSet.getString("id"),
                                    resultSet.getInt("idCenter"),
                                    resultSet.getString("firstName"),
                                    resultSet.getString("lastName"),
                                    resultSet.getDate("dateRegister"),
                                    resultSet.getString("nif"),
                                    resultSet.getString("email"),
                                    resultSet.getString("type"));
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> queryUser(String username) {

        try (Connection connection = DAOFactoryJDBC.createConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE firstName LIKE ?")) {
                preparedStatement.setString(1, "%"+username+"%");

                ResultSet resultSet = preparedStatement.executeQuery();
                List<User> results = new ArrayList<>();
                while (resultSet.next()) {
                    results.add(new User(resultSet.getString("id"),
                                            resultSet.getInt("idCenter"),
                                            resultSet.getString("firstName"),
                                            resultSet.getString("lastName"),
                                            resultSet.getDate("dateRegister"),
                                            resultSet.getString("nif"),
                                            resultSet.getString("email"),
                                            resultSet.getString("type")));
                }
                return results;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Application> getApplications(String userId) {
        try (Connection connection = DAOFactoryJDBC.createConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT application.* FROM application " +
                                                                                        " JOIN belongto ON belongto.idApplication = application.id" +
                                                                                        " JOIN user ON user.id = belongto.idUser WHERE user.id = ?;")) {
                preparedStatement.setString(1, userId);

                ResultSet resultSet = preparedStatement.executeQuery();

                List<Application> results = new ArrayList<>();
                while (resultSet.next()) {
                    results.add(new Application(resultSet.getInt("id"),
                                                resultSet.getString("status"),
                                                resultSet.getString("content")));
                }
                return results;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public Center getCenter(int id) {
        try (Connection connection = DAOFactoryJDBC.createConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM center WHERE id = ?")){
                preparedStatement.setInt(1, id);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return new Center(resultSet.getInt("id"),
                                        resultSet.getString("name"));
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
