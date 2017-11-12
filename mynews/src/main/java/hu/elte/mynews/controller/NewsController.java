
package hu.elte.mynews.controller;

import hu.elte.mynews.annotation.Role;
import hu.elte.mynews.entity.Comment;
import hu.elte.mynews.entity.News;
import hu.elte.mynews.entity.Report;
import hu.elte.mynews.entity.User;
import static hu.elte.mynews.entity.User.Role.ADMIN;
import static hu.elte.mynews.entity.User.Role.USER;
import hu.elte.mynews.exception.NewsException;
import hu.elte.mynews.exception.UserException;
import hu.elte.mynews.repository.CommentRepository;
import hu.elte.mynews.repository.NewsRepository;
import hu.elte.mynews.repository.ReportRepository;
import hu.elte.mynews.service.NewsService;
import hu.elte.mynews.service.SessionService;
import hu.elte.mynews.service.UserService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    
    @GetMapping
    public ResponseEntity<Iterable<News>> list(){
        return ResponseEntity.ok(newsService.list());
    }
    
    @Role({USER, ADMIN})
    @PostMapping("/addnews")
    public ResponseEntity<News> addNews(@RequestBody News news) {
        try{
            return ResponseEntity.ok(newsService.newNews(news));
        } catch (UserException ex) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @Role({USER, ADMIN})
    @PutMapping("/{rate}/{id}")
    private ResponseEntity<News> rate(@PathVariable String rate, @PathVariable long id, @RequestBody News news){
        try{
            return ResponseEntity.ok(newsService.rate(id, rate, news));
        } catch (NewsException ex) {
            return ResponseEntity.badRequest().build();
        }
    }
    //reportolás
}
