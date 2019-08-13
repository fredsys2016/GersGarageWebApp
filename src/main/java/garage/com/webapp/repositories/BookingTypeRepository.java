package garage.com.webapp.repositories;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import garage.com.webapp.entities.BookingType;

@Repository
public interface BookingTypeRepository extends JpaRepository<BookingType, Integer> {
	
    
    @Query(value = "SELECT * FROM bookingtype bt WHERE bt.id_bookingtype =:idtype" , nativeQuery = true)
    public BookingType findTypeByID(@Param("idtype") int id);

}