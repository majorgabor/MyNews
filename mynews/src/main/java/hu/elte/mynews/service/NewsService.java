
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
    
    public Iterable<News> getAllNews(){
        return newsRepository.findAll();
    }
    
    public News getNewsById(long id){
        return newsRepository.findOne(id);
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
    
    public News rate(long id, String rate) throws NewsException, UserException {
        News ratedNews = newsRepository.findOne(id);
        if (ratedNews != null && ( rate.equals("like") || rate.equals("dislike") || rate.equals("unrate"))){
            if(rate.equals("like")){
                ratedNews.getDislikerUser().remove(userService.findUser(userService.getCurrentUser().getId()));
                ratedNews.getLikerUser().add(userService.findUser(userService.getCurrentUser().getId()));
                ratedNews.setLikes(ratedNews.getLikerUser().size());
                ratedNews.setDislikes(ratedNews.getDislikerUser().size());
                userService.likeNews(ratedNews);
            }
            else if(rate.equals("unrate")){
                ratedNews.getLikerUser().remove(userService.findUser(userService.getCurrentUser().getId()));
                ratedNews.getDislikerUser().remove(userService.findUser(userService.getCurrentUser().getId()));
                ratedNews.setLikes(ratedNews.getLikerUser().size());
                ratedNews.setDislikes(ratedNews.getDislikerUser().size());
                userService.unRateNews(ratedNews);
            }
            else if(rate.equals("dislike")){
                ratedNews.getLikerUser().remove(userService.findUser(userService.getCurrentUser().getId()));
                ratedNews.getDislikerUser().add(userService.findUser(userService.getCurrentUser().getId()));
                ratedNews.setLikes(ratedNews.getLikerUser().size());
                ratedNews.setDislikes(ratedNews.getDislikerUser().size());
                userService.dislikeNews(ratedNews);
            }
            newsRepository.save(ratedNews);
            return ratedNews;
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
