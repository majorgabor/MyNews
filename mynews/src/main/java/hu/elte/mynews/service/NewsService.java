
package hu.elte.mynews.service;

import hu.elte.mynews.entity.Comment;
import hu.elte.mynews.entity.News;
import hu.elte.mynews.exception.CommentException;
import hu.elte.mynews.exception.NewsException;
import hu.elte.mynews.exception.UserException;
import hu.elte.mynews.repository.NewsRepository;
import static java.util.Arrays.asList;
import java.util.Date;
import java.util.List;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
@Data
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;
    
    public Iterable<News> list(){
        return newsRepository.findAll();
    }
    
    public News newNews(News news) throws UserException{
    news.setDate(new Date());
        news.setLikes(0);
        news.setDislikes(0);
        news.setUser( userService.getCurrentUser());
        newsRepository.save(news);
        userService.newNews(news);
        return news;
    }
    
    public News rate(long id, String rate, News news) throws NewsException {
        News likedNews = newsRepository.findOne(id);
        if (likedNews != null && ( rate.equals("like") || rate.equals("dislike") )){
            if(rate.equals("like")) likedNews.setLikes((likedNews.getLikes()+1));
            if(rate.equals("dislike")) likedNews.setDislikes((likedNews.getDislikes()+1));
            newsRepository.save(likedNews);
            return likedNews;
        } else {
            throw new NewsException();
        }
    }
    
    public News newComment(long id, Comment comment) throws NewsException {
        News commentedNews = newsRepository.findOne(id);
        if(commentedNews != null){
            commentedNews.getComment().add(comment);
            newsRepository.save(commentedNews);
            return commentedNews;
        } else {
            throw new NewsException();
        }
    }
    
    public News deleteNews(long id) throws NewsException, UserException, CommentException{
        News deleteNews = newsRepository.findOne(id);
        if(deleteNews != null){
            commentService.deleteNewsComment(deleteNews.getComment());
            long userId = deleteNews.getUser().getId();
            userService.deleteNews(userId, deleteNews);
            newsRepository.delete(deleteNews);
            return deleteNews;
        } else {
            throw new NewsException();
        }
    }
    

    public News deleteComment(long newsId, Comment comment) throws NewsException {
        News commentedNews = newsRepository.findOne(newsId);
        if(commentedNews != null){
            commentedNews.getComment().remove(comment);
            newsRepository.save(commentedNews);
            return commentedNews;
        } else {
            throw new NewsException();
        }
    }
}
