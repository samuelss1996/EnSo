package model.data;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sell {
	private String id;
	private Date sellDate;
	private String idUser;
	private List<SellLine> sellLines;
	private float totalPrice;

	public Sell() {
	    this.sellLines = new ArrayList<>();
    }

    public Sell(String id, Date sellDate, String idUser, float totalPrice){
		this.id=id;
		this.sellDate=sellDate;
		this.idUser=idUser;
		this.totalPrice=totalPrice;
		this.sellLines = new ArrayList<>();
	}
	public void addLine(SellLine line) {
		this.sellLines.add(line);
	}
	
	public void removeLine(SellLine line) {
		this.sellLines.remove(line);
	}
	
	public List<SellLine> getSellLines() {
		return sellLines;
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
