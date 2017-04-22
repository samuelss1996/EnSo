package model.data;


import java.util.Date;
import java.util.List;

public class Sell {
	private String id;
	private Date sellDate;
	private String idUser;
	private List<SellLine> sellLines;
	private float totalPrice;


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

	public String getIduser() {
		return idUser;
	}

	public void setUser(String idUser) {
		this.idUser = idUser;
	}

	public void setSellLines(List<SellLine> sellLines) {
		this.sellLines = sellLines;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
}
