package model.data;


import java.util.List;

public class ImportData {
	private List<User> users;
	private List<Product> products;
	private List<Sell> sells;
	public void addUser(User user) {
		if (!users.contains(user)) users.add(user);
	}
	
	public void addProduct(Product product) {
		if (!products.contains(product)) products.add(product);
	}
	
	public void addSell(Sell sell) {
		if (!sells.contains(sell)) sells.add(sell);
	}
}
