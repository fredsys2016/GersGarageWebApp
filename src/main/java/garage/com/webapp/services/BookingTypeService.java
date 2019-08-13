package garage.com.webapp.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import garage.com.webapp.repositories.BookingTypeRepository;
import garage.com.webapp.entities.BookingType;

@Service
public class BookingTypeService {
	
	@Autowired
	private BookingTypeRepository bookingTypeRep;
	

	public List<BookingType>findALL()
	{
		return bookingTypeRep.findAll(); 
	}
}
