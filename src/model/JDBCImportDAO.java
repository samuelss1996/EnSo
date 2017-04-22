package model;


import model.data.Product;
import model.data.Sell;
import model.data.SellLine;
import model.data.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCImportDAO implements IDAOImport {
	public void doImport(ImportData data) {
        try (Connection connection = DAOFactoryJDBC.createConnection()) {
            connection.setAutoCommit(false);

            PreparedStatement userStatement = connection.prepareStatement("INSERT into USER (id, idCenter, firstName, lastName, email, nif, type) values (?, ?, ?, ?, ?, ?, ?)");
            for (User user : data.getUsers()) {
                insertUser(user, userStatement);
            }

            PreparedStatement productStatement = connection.prepareStatement("INSERT INTO products (id, name, stock, available, availableSince, category, description, currentPrice) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            for (Product product : data.getProducts()) {
                insertProduct(product, productStatement);
            }

            PreparedStatement sellStatement = connection.prepareStatement("INSERT INTO sell (id, totalPrice, idUser) VALUES (?, ?, ?)");
            PreparedStatement lineStatement = connection.prepareStatement("INSERT INTO lineacompra (quantity, totalPrice, unitPrice, lineSell, idSell, idProducts) VALUES (?, ?, ?, ?, ?, ?)");
            for (Sell sell : data.getSells()) {
                insertSell(sell, sellStatement);
                int lineNumber = 0;
                for (SellLine line : sell.getSellLines()) {
                    insertSellLine(line, lineStatement, lineNumber++, sell.getId());
                }
            }

            try {
                userStatement.executeBatch();
                productStatement.executeBatch();
                sellStatement.executeBatch();
                lineStatement.executeBatch();

                connection.commit();
            } catch (SQLException ex) {
                connection.rollback();
                ex.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertSellLine(SellLine line, PreparedStatement statement, int lineNumber, String sellId) throws SQLException {
	    statement.setInt(1, line.getQuantity());
	    statement.setFloat(2, line.getTotalPrice());
	    statement.setFloat(3, line.getUnitPrice());
	    statement.setInt(4, lineNumber);
	    statement.setString(5, sellId);
	    statement.setString(6, line.getProduct().getId());

	    statement.addBatch();

    }

    private void insertSell(Sell sell, PreparedStatement statement) throws SQLException {
        statement.setString(1, sell.getId());
        statement.setFloat(2, sell.getTotalPrice());
        statement.setDate(3, new java.sql.Date(sell.getSellDate().getTime()));

        statement.addBatch();
	}

	private void insertUser(User user, PreparedStatement statement) throws SQLException {
        statement.setString(1, user.getId());
        statement.setInt(2, user.getCenter());
        statement.setString(3, user.getFirstName());
        statement.setString(4, user.getLastName());
        statement.setString(5, user.getEmail());
        statement.setString(6, user.getNIF());
        statement.setString(7, user.getTypeUser());

        statement.addBatch();
	}

	private void insertProduct(Product product, PreparedStatement statement) throws SQLException {
        statement.setString(1, product.getId());
        statement.setString(2, product.getName());
        statement.setInt(3, product.getStock());
        statement.setBoolean(4, product.isAvailable());
        statement.setDate(5, new java.sql.Date(product.getAvailableSince().getTime()));
        statement.setString(6, product.getCategory());
        statement.setString(7, product.getDescription());
        statement.setFloat(3, product.getCurrentPrice());

        statement.addBatch();
	}
}
