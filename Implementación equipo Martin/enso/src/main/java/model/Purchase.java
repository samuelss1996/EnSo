package model;

import java.sql.Date;

public class Purchase {
	private String ID_Purchase;
	private Order order;
	private Date date;
	private float discount;
	

	
	
	public Purchase(String iD_Purchase, Order order, Date date, float discount) {
		super();
		ID_Purchase = iD_Purchase;
		this.order = order;
		this.date = date;
		this.discount = discount;
		

	}	
	
	public Purchase(String iD_Purchase, Date date) {
		super();
		ID_Purchase = iD_Purchase;
		this.date = date;
		
		
	}

	
	
	
	
	//GETTERS && SETTERS
	public String getID_Purchase() {
		return ID_Purchase;
	}

	public void setID_Purchase(String iD_Purchase) {
		ID_Purchase = iD_Purchase;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}


	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	

}
