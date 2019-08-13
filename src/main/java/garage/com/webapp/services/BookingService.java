package garage.com.webapp.services;



import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import garage.com.webapp.repositories.BookingRepository;
import garage.com.webapp.repositories.BookingTypeRepository;
import garage.com.webapp.entities.Booking;
import garage.com.webapp.entities.BookingType;


@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookRep;

	@Autowired
	private BookingTypeRepository bookTypeRep;
	

	
	public List<Booking> findAllAvailableBy (String status){
		return bookRep.findByStatus(status);
	}
	
	/**
	 * This function updates and Insert  
	 * @param booking
	 * @return boolean
	 */
	public boolean save(Booking booking) 
	{ 
		try {
			bookRep.save(booking);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}
	
	public boolean deleteBooking(Long id)
	{
		try {
			bookRep.deleteById(id);
		}
		catch(Exception e){return false;}
		return true;
	}
	
	public List<Booking>findAllAvailableBooking(String date)
	{
		return bookRep.findAvailableBooking(date);
	}
	
	public Booking findBookingByID(Long id)
	{
		return bookRep.findBookingbyID(id);
	}



	public List<Booking>findAllBooked()
	{
		List<Booking>filledList=bookRep.findAllBooked();

		for(int i=0 ; i< filledList.size();i++)
		{
			Booking booking=filledList.get(i);
			BookingType bookType=bookTypeRep.findTypeByID(booking.getBookingtype().getId_bookingtype());
			booking.setBookingtype(bookType);
			filledList.set(i, booking);
		}
		return filledList;
	}
}
