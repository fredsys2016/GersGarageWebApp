package garage.com.webapp.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import garage.com.webapp.entities.EngineType;

@Repository
public interface EngineTypeRepository extends JpaRepository<EngineType, Integer> {
}