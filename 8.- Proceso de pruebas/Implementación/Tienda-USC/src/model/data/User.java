package model.data;


import java.util.Date;

public class User {
	private String id;
	private int center;
	private String firstName;
	private String lastName;
	private Date registerDate;
	private String NIF;
	private String email;
	public String typeUser;

    public User() {
    }

    public User(String id, int center, String firstName, String lastName, Date registerDate, String NIF, String email, String typeUser) {
        this.id = id;
        this.center = center;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registerDate = registerDate;
        this.NIF = NIF;
        this.email = email;
        this.typeUser = typeUser;
    }

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

    public int getCenter() {
        return center;
    }

    public void setCenter(int center) {
        this.center = center;
    }

    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String NIF) {
		this.NIF = NIF;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}
}
