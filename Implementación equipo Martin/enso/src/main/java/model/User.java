package model;

import java.sql.Date;

public class User {
	private String ID_User;
	private String name;
	private String surname;
	private String NIF;
	private Date date;
	private String tipe;
	

	public static final String ALUMN = "alumno";
	public static final String ADMIN = "Gestor";
	public static final String PID = "PID/PAS";
	
	
	public User(String iD_User, String name, String surname, String NIF, Date date, String tipe) {
		super();
		ID_User = iD_User;
		this.name = name;
		this.surname = surname;
		this.NIF = NIF;
		this.date = date;
		this.tipe = tipe;
	}


	
	
	
	
	

	@Override
	public String toString() {
		return "User [ID_User=" + ID_User + ", name=" + name + ", surname=" + surname + ", NIF=" + NIF + ", date="
				+ date + ", tipe=" + tipe + "]";
	}

	
	//GETTERS && SETTERS
	public String getID_User() {
		return ID_User;
	}

	public void setID_User(String iD_User) {
		ID_User = iD_User;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTipe() {
		return tipe;
	}

	public void setTipe(String tipe) {
		this.tipe = tipe;
	}

	public String getNIF() {
		return NIF;
	}
	
	public void setNIF(String nIF) {
		NIF = nIF;
	}
	
	
	
	
	
	
	
	
}
