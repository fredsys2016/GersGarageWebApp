package garage.com.webapp.repositories;



import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import garage.com.webapp.entities.Booking;



@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	public List<Booking> findByStatus(String status);
	
	@Query(value=" SELECT * FROM booking b WHERE b.date=:date AND b.status='Available'", nativeQuery =true)
	public List<Booking>findAvailableBooking(@Param("date") String date);

	@Query(value="SELECT * FROM booking b WHERE b.id_booking=:id_booking" ,nativeQuery = true)
	public Booking findBookingbyID(@Param("id_booking") Long id_booking);
	

	@Query(value="SELECT * FROM booking b WHERE b.id_bookingtype != 'Null'" ,nativeQuery = true)
	public List<Booking> findAllBooked();
}
