
package hu.elte.mynews.repository;

import hu.elte.mynews.entity.Messege;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessegeRepository extends CrudRepository<Messege, Long>{
    
}
