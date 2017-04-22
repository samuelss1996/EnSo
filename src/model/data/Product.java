package model.data;


import java.util.Date;

public class Product {
	private String id;
	private String name;
	private int stock;
	private boolean available;
	private Date availableSince;
	private String category;
	private String description;
	private Object currentPrice;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Date getAvailableSince() {
		return availableSince;
	}

	public void setAvailableSince(Date availableSince) {
		this.availableSince = availableSince;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Object getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Object currentPrice) {
		this.currentPrice = currentPrice;
	}
}
