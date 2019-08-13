package garage.com.webapp.services;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import garage.com.webapp.entities.Person;
import garage.com.webapp.repositories.PersonRepository;


@Service
public class PersonService {
	
	@Autowired 
	private PersonRepository personRep;
	
	/**
	 * function savePerson
	 * @param person
	 * @return boolean
	 */
	public boolean savePerson(Person person)
	{
		try {
			personRep.save(person);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	/**
	 * This function delete by Id
	 * @param id
	 * @return
	 */
	public boolean deletePersonById(Long id)
	{
		try {personRep.deleteById(id);}catch(Exception e){return false;}return true;
	}
	
	//Queries
	/*
	public List<Person> findAllByStatus(String role)
	{
		return personRep.findByStatus(role);
	}
	*/

	//Customers
	public Person finByEmail(String email)
	{
		return personRep.findByEmail(email);
	}



}