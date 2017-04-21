package model;

import model.IDAOProduct;
import model.Product;

import java.util.List;

public class JDBCProductDAO implements IDAOProduct {
    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void updateAvailability(Product product) {

    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public Product fetchProduct(int productId) {
        return null;
    }

    @Override
    public List<Product> queryProduct(String name) {
        return null;
    }

    @Override
    public int queryStock(int productId) {
        return 0;
    }
}
