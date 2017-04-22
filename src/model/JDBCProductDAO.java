package model;

import com.sun.scenario.effect.impl.prism.ps.PPSBlend_REDPeer;
import model.data.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCProductDAO implements IDAOProduct {
    @Override
    public void addProduct(Product product) {
        try (Connection connection = DAOFactoryJDBC.createConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO products (id, name, stock, available, availableSince, category, description, currentPrice) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
                preparedStatement.setString(1, product.getId());
                preparedStatement.setString(2, product.getName());
                preparedStatement.setInt(3, product.getStock());
                preparedStatement.setBoolean(4, product.isAvailable());
                preparedStatement.setDate(5, new java.sql.Date(product.getAvailableSince().getTime()));
                preparedStatement.setString(6, product.getCategory());
                preparedStatement.setString(7, product.getDescription());
                preparedStatement.setFloat(3, product.getCurrentPrice());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAvailability(Product product) {
        try (Connection connection = DAOFactoryJDBC.createConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE products SET available = ? WHERE id = ?")) {
                preparedStatement.setBoolean(1, product.isAvailable());
                preparedStatement.setString(2, product.getId());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProduct(Product product) {
        try (Connection connection = DAOFactoryJDBC.createConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE products SET name = ?, " +
                                                                                    " stock = ?, " +
                                                                                    "available = ?, " +
                                                                                    "availableSince = ?, " +
                                                                                    "category = ?, " +
                                                                                    "description = ?, " +
                                                                                    "currentPrice = ? " +
                                                                                    "WHERE id = ?")) {
                preparedStatement.setString(1, product.getName());
                preparedStatement.setInt(2, product.getStock());
                preparedStatement.setBoolean(3, product.isAvailable());
                preparedStatement.setDate(4, new java.sql.Date(product.getAvailableSince().getTime()));
                preparedStatement.setString(5, product.getCategory());
                preparedStatement.setString(6, product.getDescription());
                preparedStatement.setFloat(7, product.getCurrentPrice());
                preparedStatement.setString(8, product.getId());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product fetchProduct(String productId) {
        try (Connection connection = DAOFactoryJDBC.createConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE id = ?")) {
                preparedStatement.setString(1, productId);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return new Product(resultSet.getString("id"),
                                        resultSet.getString("name"),
                                        resultSet.getInt("stock"),
                                        resultSet.getBoolean("available"),
                                        resultSet.getDate("availableSince"),
                                        resultSet.getString("category"),
                                        resultSet.getString("description"),
                                        resultSet.getFloat("currentPrice"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> queryProduct(String name) {
        try (Connection connection = DAOFactoryJDBC.createConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE name LIKE '%' || ? || '%'")) {
                preparedStatement.setString(1, name);

                ResultSet resultSet = preparedStatement.executeQuery();

                List<Product> results = new ArrayList<>();
                while (resultSet.next()) {
                    results.add(new Product(resultSet.getString("id"),
                                            resultSet.getString("name"),
                                            resultSet.getInt("stock"),
                                            resultSet.getBoolean("available"),
                                            resultSet.getDate("availableSince"),
                                            resultSet.getString("category"),
                                            resultSet.getString("description"),
                                            resultSet.getFloat("currentPrice")));
                }
                return results;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public int queryStock(String productId) {
        try (Connection connection = DAOFactoryJDBC.createConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT stock FROM products WHERE id = ?")) {
                preparedStatement.setString(1, productId);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next())
                    return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
