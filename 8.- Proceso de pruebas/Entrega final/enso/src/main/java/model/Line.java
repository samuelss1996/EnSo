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











	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + quantity;
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
		Line other = (Line) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}		

	
	
}
