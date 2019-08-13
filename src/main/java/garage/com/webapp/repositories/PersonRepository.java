package garage.com.webapp.repositories;




import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import garage.com.webapp.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	/*
	@Query(value="SELECT * FROM person p INNER JOIN Roles r ON p.id_role==p.id_role where r.name=:name", nativeQuery=true)
	public List<Person> findByStatus(@Param("name")String name);
	*/
	//Queries Customers
	//@Query(value = "SELECT p.id_person, p.first_name , p.last_name, p.email FROM person p WHERE p.email=:email")
	public Person findByEmail(String email);

	
	
}
