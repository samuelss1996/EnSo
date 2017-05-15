package model;

public class Line {

	private int quantity;
	private float price;
	private Item item;
	
	public Line(int quantity, float price, Item item) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.item = item;
	}
	
	
	
	
	
	
	
	
	
	

	//GETTERS && SETTERS
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}		

	
	
}
