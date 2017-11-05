
package hu.elte.mynews.controller;

import hu.elte.mynews.annotation.Role;
import hu.elte.mynews.entity.Comment;
import hu.elte.mynews.entity.News;
import hu.elte.mynews.entity.Report;
import hu.elte.mynews.entity.User;
import static hu.elte.mynews.entity.User.Role.USER;
import hu.elte.mynews.repository.CommentRepository;
import hu.elte.mynews.repository.NewsRepository;
import hu.elte.mynews.repository.ReportRepository;
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
    private ReportRepository reportRepository;
    
    
    @GetMapping("/timeline")
    public String list(Model model){
        Iterable<News> list = newsRepository.findAll();
        model.addAttribute("news", list);
        return "mynews";
    }
    
    //@Role({User.Role.USER, User.Role.ADMIN})
    @PostMapping("/addnews")
    public String addNews(@RequestBody News newNews) {
        newsRepository.save(newNews);
        return "redirect:/news/timeline";
    }
    
    //@Role({User.Role.USER, User.Role.ADMIN})
    @PostMapping("/addcomment")
    public String addComment(@RequestBody Comment newComment) {
        commentRepository.save(newComment);
        return "redirect:/news/timeline";
    }
    
    //@Role({User.Role.USER, User.Role.ADMIN})
    @PostMapping("/addreport")
    public String addReport(@RequestBody Report newReport) {
        reportRepository.save(newReport);
        return "redirect:/news/timeline";
    }
}
