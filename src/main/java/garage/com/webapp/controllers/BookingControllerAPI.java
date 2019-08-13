package garage.com.webapp.controllers;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import garage.com.webapp.entities.Booking;
import garage.com.webapp.services.BookingService;

@RestController
public class BookingControllerAPI {
	
	@Autowired
	private BookingService bookingServ;
	
	//Return a JSON with the list of Booking Available;

	
	@GetMapping("/availablesBookings")
	public List<Booking> ShowAvailableBooking(@RequestParam("date") String date)
	{
		return bookingServ.findAllAvailableBooking(date);
	}
	

	@GetMapping("/nuevaLista")
	public List<Booking> showAllBooked()
	{
		//List<Booking>newList
		return bookingServ.findAllBooked();
	}
}