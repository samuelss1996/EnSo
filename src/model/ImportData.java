package model;

import java.util.List;
import model.data.*;

public class ImportData {
	private List<User> users;
	private List<Product> products;
	private List<Sell> sells;

	public void addUser(User user) {
		this.users.add(user);
	}
	
	public void addProduct(Product product) {
		this.products.add(product);
	}
	
	public void addSell(Sell sell) {
		this.sells.add(sell);
	}

	public boolean containsSell(String sellId) {
		return this.sells.stream().anyMatch(sell -> sell.getId().equals(sellId));
	}

    public Sell getSellById(String sellId) {
        return this.sells.stream().filter(sell -> sell.getId().equals(sellId)).findFirst().get();
	}
}
