package model;

import model.data.Product;
import model.data.Sell;
import model.data.User;

import java.util.List;

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

    public List<User> getUsers() {
        return users;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Sell> getSells() {
        return sells;
    }
}
