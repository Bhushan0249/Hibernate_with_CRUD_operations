package Hibernate.CRUD;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@Column
	public int id;
	@Column
	public String name;
	@Column
	public String email;
	@Column
	public String password;
	@Column
	public String gender;
	@Column
	public String city;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public User(int id, String name, String email, String password, String gender, String city) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.city = city;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "id: " + id + "  name: " + name + "  email: " + email + "  password: " + password + "  gender: " + gender
				+ ":  city: " + city;
	}

}
