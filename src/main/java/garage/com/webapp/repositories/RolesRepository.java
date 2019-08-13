package garage.com.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import garage.com.webapp.entities.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
	@Query(value="SELECT * FROM roles  WHERE id_role=:id_role", nativeQuery=true)
	public Roles findOneByID(@Param("id_role") int id_role);
}