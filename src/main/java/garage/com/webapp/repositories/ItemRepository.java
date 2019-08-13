package garage.com.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import garage.com.webapp.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long>
{

}
