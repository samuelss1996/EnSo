package model.data;


import java.util.Date;
import java.util.List;

public class Sell {
	private int id;
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
}
