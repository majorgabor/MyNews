
package hu.elte.mynews.repository;

import hu.elte.mynews.entity.News;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends CrudRepository<News, Long> {
    
}
