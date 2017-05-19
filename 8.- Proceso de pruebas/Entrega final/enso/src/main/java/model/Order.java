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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID_Order;
		result = prime * result + ((lines == null) ? 0 : lines.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((validator == null) ? 0 : validator.hashCode());
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
		Order other = (Order) obj;
		if (ID_Order != other.ID_Order)
			return false;
		if (lines == null) {
			if (other.lines != null)
				return false;
		} else if (!lines.equals(other.lines))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (validator == null) {
			if (other.validator != null)
				return false;
		} else if (!validator.equals(other.validator))
			return false;
		return true;
	}
}
