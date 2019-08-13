package garage.com.webapp.entities;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_person;
	
	private String first_name;
	private String last_name;
	private String phone_number;
	private String email;
	private String password;
	private int active;
	
	
	
	
	
	//Id_Role
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_role")
	private Roles roles;

	/*
	@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
	private List<Booking> bookings;

	
	
	
	public List<Booking> getBookings() {
		return bookings;
	}


	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}*/

	/**
	 * Getter and Setter
	 * 
	 */
	public Long getId_person() {
		return id_person;
	}


	public void setId_person(Long id_person) {
		this.id_person = id_person;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getPhone_number() {
		return phone_number;
	}


	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
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


	public int getActive() {
		return active;
	}


	public void setActive(int active) {
		this.active = active;
	}



	public Roles getRoles() {
		return roles;
	}


	public void setRoles(Roles roles) {
		this.roles = roles;
	}
	
	
}
