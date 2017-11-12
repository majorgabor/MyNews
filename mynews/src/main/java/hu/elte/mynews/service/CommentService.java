
package hu.elte.mynews.service;

import hu.elte.mynews.entity.Comment;
import hu.elte.mynews.exception.NewsException;
import hu.elte.mynews.exception.UserException;
import hu.elte.mynews.repository.CommentRepository;
import hu.elte.mynews.repository.NewsRepository;
import java.util.Date;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
@Data
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private NewsService newsService;
    
    
    public Iterable<Comment> list(){
        return commentRepository.findAll();
    }
    
    public Comment newComment(long id, Comment comment) throws UserException, NewsException{
        comment.setDate(new Date());
        comment.setLikes(0);
        comment.setDislikes(0);
        comment.setUser(userService.getCurrentUser().getId());
        if(newsRepository.findOne(id) != null){
            comment.setNews(id);
            commentRepository.save(comment);
            return comment;
        } else {
            throw new NewsException();
        }
    }
}
