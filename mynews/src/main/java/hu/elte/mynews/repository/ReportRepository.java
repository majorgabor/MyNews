
package hu.elte.mynews.repository;

import hu.elte.mynews.entity.Report;
import org.springframework.data.repository.CrudRepository;


public interface ReportRepository extends CrudRepository<Report, Long>{
    
}
