package garage.com.webapp.controllers;
 


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import garage.com.webapp.entities.Booking;
import garage.com.webapp.services.BookingService;
//import garage.com.webapp.services.BookingService;
import garage.com.webapp.services.BookingTypeService;
import garage.com.webapp.services.VehicleService;
import garage.com.webapp.entities.BookingType;
import garage.com.webapp.entities.Vehicle;
import garage.com.webapp.Status;

@Controller
public class BookingController {

	@Autowired
	private BookingService bookingServ;

	@Autowired 
	private BookingTypeService bookingTypeServ;

	@Autowired
	private VehicleService vehicleServ;

	private Status status=new Status();; 



/*	
	@RequestMapping("/appointments/{id}")
	public ModelAndView ShowAvailables(@PathVariable(name="id") Long id) {
		//ModelAndView model =new ModelAndView("showBookingAvailable");

		Map<String,Object>model =new HashMap<String, Object>();
		
		Booking booking=new Booking();
		List<BookingType> listBookingT=bookingTypeServ.findALL();
		List<Vehicle> listVehicle=vehicleServ.findByIdPerson(id);
		//find booking's customer
		model.put("booking",booking);
		model.put("listBookingT",listBookingT);
		model.put("listVehicle",listVehicle);
		return new ModelAndView("showBookingAvailable", "model", model);
	}
*/

@RequestMapping("/appointments")
public String findBookings(Model model)
{
	Booking booking=new Booking();

	List<BookingType> listBookingType=bookingTypeServ.findALL();
	
		//Long = number + L   Modificar codigo
	List<Vehicle> listVehicle=vehicleServ.findByIdPerson(1L);

	model.addAttribute("booking", booking);
	model.addAttribute("listBookingType", listBookingType);
	model.addAttribute("listVehicle", listVehicle);

	return "./WebP/showBookingAvailable";
}

/*
	@RequestMapping("/appointments")
	public ModelAndView ShowAvailables() {
		//ModelAndView model =new ModelAndView("showBookingAvailable");

		Map<String,Object>model =new HashMap<String, Object>();
		
		Booking booking=new Booking();
		List<BookingType> listBookingType=bookingTypeServ.findALL();
		//Long = number + L
		List<Vehicle> listVehicle=vehicleServ.findByIdPerson(1L);
		model.put("booking",booking);
		model.put("listBookingType",listBookingType);
		model.put("listVehicle",listVehicle);
		return new ModelAndView("./WebP/showBookingAvailable", "model", model);
	}
*/	

/**
 * to save  booking from customer 
 * @param booking
 * @return file appointment html
 */
	@RequestMapping(value="/saveB", method = RequestMethod.POST)
	public String saveBooking(@ModelAttribute("booking") Booking booking )
	{
		bookingServ.save(booking);
		return "redirect:/appointments";
	}


	//No finished
	@RequestMapping(value="/book", method = RequestMethod.POST)
	public String bookAppointment(@ModelAttribute("booking") Booking booking )
	{
		Booking oldBooking=bookingServ.findBookingByID(booking.getId_booking());
		booking.setDate(oldBooking.getDate());
		booking.setTime(oldBooking.getTime());
		booking.setStatus(status.Booked());


		bookingServ.save(booking);
		return "redirect:/appointments";
	}
	
	
	/**this function cancel the Customer's Booking
	 * Entity Booking
	 * this function change status of booking from booked to available
	 * @param id 
	 * @return
	 */
	@RequestMapping("/cancelBooking/{id}")
	public String cancelBooking(@PathVariable(name="id") Long id) {
		//ModelAndView model = new ModelAndView("showBookingAvailable");

		
		
		Booking booking=new Booking();
		Booking upBooking=new Booking(); 
		
		booking = bookingServ.findBookingByID(id);
		//check if status booking is "booked" for change
		
		if(booking.getStatus()==status.Booked())
		{
			upBooking.setId_booking(booking.getId_booking());
			upBooking.setStatus(status.Available());//changing status 
			upBooking.setDate(booking.getDate());
			upBooking.setTime(booking.getTime());
			bookingServ.save(upBooking);
		}
		
		return "redirect:/appointments";
	}
	
	
/**
 * code from Wed Admin
 */

	@RequestMapping("/newBooking")
	public String showNewBooking(Model model)
	{
		Booking booking=new Booking();
		model.addAttribute("booking", booking);

		return "./WebAdmin/newBooking";
	}
	
	@RequestMapping(value="/saveNB", method = RequestMethod.POST)
	public String saveBookingNew(@ModelAttribute("booking") Booking booking )
	{
		booking.setStatus(status.Available());
		bookingServ.save(booking);
		return "redirect:/newBooking";
	}


}