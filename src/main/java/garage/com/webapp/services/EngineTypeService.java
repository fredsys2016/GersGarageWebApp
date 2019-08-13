package garage.com.webapp.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import garage.com.webapp.repositories.EngineTypeRepository;
import garage.com.webapp.entities.EngineType;

@Service
public class EngineTypeService {
	@Autowired
	private EngineTypeRepository engineTypeRep;
	
	public List<EngineType> findAll()
	{
		return engineTypeRep.findAll();
	}
	
	
}