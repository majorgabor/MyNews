
package hu.elte.mynews.controller;

import hu.elte.mynews.entity.User;
import hu.elte.mynews.repository.UserRepository;
import hu.elte.mynews.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/datasheet")
public class DataSheetController {
    @Autowired
    private SessionService sessionService;
    @Autowired
    private UserRepository userRepository;
    
    //@Role({User.Role.USER, User.Role.ADMIN})
    @GetMapping("/mydata")
    public String show(Model model){
        User me = sessionService.getCurrentUser();
        model.addAttribute("me", me);
        return "datasheet";
    }
    //@Role({User.Role.USER, User.Role.ADMIN})
    @GetMapping("/users")
    public String list(Model model){
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "users";
    }
}
