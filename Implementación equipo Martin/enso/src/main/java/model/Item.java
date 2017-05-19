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










	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((availableDate == null) ? 0 : availableDate.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((itemRef == null) ? 0 : itemRef.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + stock;
		return result;
	}










	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (availableDate == null) {
			if (other.availableDate != null)
				return false;
		} else if (!availableDate.equals(other.availableDate))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (itemRef == null) {
			if (other.itemRef != null)
				return false;
		} else if (!itemRef.equals(other.itemRef))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (stock != other.stock)
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
}
