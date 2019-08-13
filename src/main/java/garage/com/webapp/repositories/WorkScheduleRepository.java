package garage.com.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import garage.com.webapp.entities.WorkSchedule;

@Repository
public interface WorkScheduleRepository extends JpaRepository<WorkSchedule, Long>
{

}
