
package hu.elte.mynews.service;

import hu.elte.mynews.entity.News;
import hu.elte.mynews.exception.NewsException;
import hu.elte.mynews.exception.UserException;
import hu.elte.mynews.repository.NewsRepository;
import java.util.Date;
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
    
//    public News newComment(long id, Comment comment) throws NewsException {
//        News commentedNews = newsRepository.findOne(id);
//        if(commentedNews != null){
//            commentedNews.getComments().add(comment);
//            newsRepository.save(commentedNews);
//            return commentedNews;
//        } else {
//            throw new NewsException();
//        }
//    }
}
