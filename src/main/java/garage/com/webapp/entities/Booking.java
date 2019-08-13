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
@Table(name="booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_booking;
	
	private String status;
	private String date;
	private String time;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_person")
	private Person person;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_vehicle")
	private Vehicle vehicle;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_bookingtype")
	private BookingType bookingtype;

	
	public Long getId_booking() {
		return id_booking;
	}

	public void setId_booking(Long id_booking) {
		this.id_booking = id_booking;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public BookingType getBookingtype() {
		return bookingtype;
	}

	public void setBookingtype(BookingType bookingtype) {
		this.bookingtype = bookingtype;
	}
	
	

}
