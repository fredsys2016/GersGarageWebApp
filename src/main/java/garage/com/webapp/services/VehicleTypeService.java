package garage.com.webapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import garage.com.webapp.repositories.VehicleTypeRepository;
import garage.com.webapp.entities.VehicleType;

@Service
public class VehicleTypeService {
	@Autowired
	private VehicleTypeRepository vehicleTypeRep;
	
	public List<VehicleType> findAll()
	{
		return  vehicleTypeRep.findAll();
	}
	
}