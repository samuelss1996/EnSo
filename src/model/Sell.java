package model;


import java.util.Date;
import java.util.List;

public class Sell {
	private String id;
	private Date sellDate;
	private User user;
	private List<SellLine> sellLines;
	private Object totalPrice;


	public void addLine(SellLine line) {
	}
	
	public void removeLine(SellLine line) {
	}
	
	public List<SellLine> getSellLines() {
		return null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getSellDate() {
		return sellDate;
	}

	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setSellLines(List<SellLine> sellLines) {
		this.sellLines = sellLines;
	}

	public Object getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Object totalPrice) {
		this.totalPrice = totalPrice;
	}
}
