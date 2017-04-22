package model;


import model.data.Product;

import java.util.List;

public interface IDAOProduct {
	void addProduct(Product product);

	void updateAvailability(Product product);

	void updateProduct(Product product);

	Product fetchProduct(String productId);

	List<Product> queryProduct(String name);

	int queryStock(String productId);
}
