package garage.com.webapp.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import garage.com.webapp.entities.Roles;
import garage.com.webapp.repositories.RolesRepository;

@Service
public class RoleService {
	@Autowired
	private RolesRepository roleRep;
	
	public List<Roles> finALL(){
		return roleRep.findAll();
	}
	
	public Roles findOneByID(int id)
	{
		return roleRep.findOneByID(id);
	}
}