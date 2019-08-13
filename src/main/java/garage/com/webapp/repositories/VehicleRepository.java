package garage.com.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import garage.com.webapp.entities.Vehicle;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	/*
	@Query(value="SELECT * FROM vehicle v INNER JOIN person p on v.id_person=p.id_person WHERE v.id_person=:id_person", nativeQuery=true)
	public List<Vehicle>findById_person(@Param("id_person") Long id_person);
*/
	


	@Query(value="SELECT * FROM vehicle where id_person=:id_person", nativeQuery=true)
	public List<Vehicle>FindListVehicle(@Param("id_person")Long id);
}