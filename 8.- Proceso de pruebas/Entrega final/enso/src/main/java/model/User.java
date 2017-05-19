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








	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID_User == null) ? 0 : ID_User.hashCode());
		result = prime * result + ((NIF == null) ? 0 : NIF.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((tipe == null) ? 0 : tipe.hashCode());
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
		User other = (User) obj;
		if (ID_User == null) {
			if (other.ID_User != null)
				return false;
		} else if (!ID_User.equals(other.ID_User))
			return false;
		if (NIF == null) {
			if (other.NIF != null)
				return false;
		} else if (!NIF.equals(other.NIF))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (tipe == null) {
			if (other.tipe != null)
				return false;
		} else if (!tipe.equals(other.tipe))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
}
