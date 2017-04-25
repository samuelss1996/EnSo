package model;

import java.util.ArrayList;

public class Order {
	private int ID_Order;
	private String state;
	private User user;
	private String validator;
	
	private ArrayList<Line> lines;
	
	public static final String WAITTING = "en espera";
	public static final String DENEGATED = "denegado";
	public static final String ACCEPTED = "aceptado";
	
	public Order(int iD_Order, User user) {
		super();
		ID_Order = iD_Order;
		this.state = WAITTING;
		this.user = user;
		
		lines =  new ArrayList<>();
	}
	
	public Order(int iD_Order, String state, User user,  String validator) {
		super();
		ID_Order = iD_Order;
		this.state = state;
		this.user = user;
		this.validator = validator;
		
		lines =  new ArrayList<>();
	}

	
	public void addLine(Line line){
		lines.add(line);
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "ID_Order=" + ID_Order + ", State=" + state + ", Author=" + user.getName() + ", Validator=" + validator+ ", lines=" + lines;
	}

	//GETTERS && SETTERS
	public int getID_Order() {
		return ID_Order;
	}


	public void setID_Order(int iD_Order) {
		ID_Order = iD_Order;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public String getValidator() {
		return validator;
	}

	public void setValidator(String validator) {
		this.validator = validator;
	}
	

	public ArrayList<Line> getLines(){
		return lines;
	}
	
	public void setLines(ArrayList<Line> lines){
		this.lines = lines;
	}
	
	
	
	
	

}
