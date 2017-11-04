
package hu.elte.mynews.controller;

import hu.elte.mynews.annotation.Role;
import hu.elte.mynews.entity.Comment;
import hu.elte.mynews.entity.News;
import hu.elte.mynews.entity.User;
import hu.elte.mynews.repository.CommentRepository;
import hu.elte.mynews.repository.NewsRepository;
import hu.elte.mynews.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private SessionService sessionService;
    
    //@Role({User.Role.USER, User.Role.ADMIN})
    @GetMapping("/timeline")
    public String list(Model model){
        News newNews = new News();
        Iterable<News> list = newsRepository.findAll();
        model.addAttribute("news", list);
        model.addAttribute("newNews", newNews);
        return "mynews";
    }
    
    //@Role({ User.Role.ADMIN})
    @PostMapping("/add")
    public String addNews(@ModelAttribute News newNews){
        newNews.setUser(sessionService.getCurrentUser());
        newsRepository.save(newNews);
        return "redirect:/news/timeline";
    }
    
    //@Role({ User.Role.ADMIN})
    @PostMapping("/addcomment")
    public String addComment(@RequestBody Comment newComment) {
        newComment.setUser(sessionService.getCurrentUser());
        commentRepository.save(newComment);
        return "redirect:/news/timeline";
    }
}
