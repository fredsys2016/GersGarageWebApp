package garage.com.webapp.entities;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="bookingtype")
public class BookingType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_bookingtype;
	
	private String name;
	
	private Float price;
	
	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	/*
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bookingtype")
	private List<Booking> booking;
*/
	
	public int getId_bookingtype() {
		return id_bookingtype;
	}

	public void setId_bookingtype(int id_bookingtype) {
		this.id_bookingtype = id_bookingtype;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
	
	

}
