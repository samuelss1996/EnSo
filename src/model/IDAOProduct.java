package model;


import model.data.Product;

import java.util.List;

public interface IDAOProduct {
	void addProduct(Product product);

	void updateAvailability(Product product);

	void updateProduct(Product product);

	Product fetchProduct(int productId);

	List<Product> queryProduct(String name);

	int queryStock(int productId);
}
