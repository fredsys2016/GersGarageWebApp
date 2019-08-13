package garage.com.webapp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import garage.com.webapp.repositories.VehicleRepository;
import garage.com.webapp.entities.Vehicle;
import java.util.List;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRep;
	
	
	public void save (Vehicle vehicle)
	{
		vehicleRep.save(vehicle);
	}
	
	public void deleteById(Long id)
	{
		vehicleRep.deleteById(id);
	}
	
	public List<Vehicle>findByIdPerson(Long id)
	{
		
		return vehicleRep.FindListVehicle(id);
	}
	
}
