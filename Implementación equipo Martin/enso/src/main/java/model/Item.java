package model;

import java.sql.Date;

public class Item {
	private String itemRef;
	private String name;
	private String description;
	private String category;
	private int stock;
	private Date availableDate;
	
	public Item(String itemRef, String name, String description, String category, int stock, Date availableDate) {
		super();
		this.itemRef = itemRef;
		this.name = name;
		this.description = description;
		this.category = category;
		this.stock = stock;
		this.availableDate = availableDate;
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Item [itemRef=" + itemRef + ", name=" + name + ", description=" + description + ", category=" + category
				+ ", stock=" + stock + ", availableDate=" + availableDate + "]";
	}	//GETTERS && SETTERS
	public String getItemRef() {
		return itemRef;
	}
	public void setItemRef(String itemRef) {
		this.itemRef = itemRef;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Date getAvailableDate() {
		return availableDate;
	}
	public void setAvailableDate(Date availableDate) {
		this.availableDate = availableDate;
	}
	
	
	
	
	
	
	
	
	
}
