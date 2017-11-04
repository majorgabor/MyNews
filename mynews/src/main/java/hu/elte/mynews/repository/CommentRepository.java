
package hu.elte.mynews.repository;

import hu.elte.mynews.entity.Comment;
import org.springframework.data.repository.CrudRepository;


public interface CommentRepository extends CrudRepository<Comment, Long>{
    
}
