
package hu.elte.mynews.controller;

import hu.elte.mynews.annotation.Role;
import hu.elte.mynews.entity.User;
import hu.elte.mynews.repository.UserRepository;
import hu.elte.mynews.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/datasheet")
public class DataSheetController {
    @Autowired
    private SessionService sessionService;
    @Autowired
    private UserRepository userRepository;
    
    @Role({User.Role.USER, User.Role.ADMIN})
    @GetMapping("/mydata")
    public String show(Model model){
        User me = sessionService.getCurrentUser();
        User modifyUser = new User();
        model.addAttribute("me", me);
        model.addAttribute("modifyUser", modifyUser);
        return "datasheet";
    }
    @Role({User.Role.USER, User.Role.ADMIN})
    @GetMapping("/users")
    public String list(Model model){
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "users";
    }
    
    @PostMapping("/modify")
    public String modify(@ModelAttribute User modifyUser){
        User actual = sessionService.getCurrentUser();
        modifyUser.setId(actual.getId());
        modifyUser.setEmail(actual.getEmail());
        modifyUser.setDate(actual.getDate());
        modifyUser.setRole(actual.getRole());
        modifyUser.setVersion(actual.getVersion());
        if(modifyUser.getName().equals("")){
            modifyUser.setName(actual.getName());
        }
        if(modifyUser.getCity().equals("")){
            modifyUser.setCity(null);
        }
        if(modifyUser.getPassword().equals("")){
            modifyUser.setPassword(actual.getPassword());
        }
        userRepository.save(modifyUser);
        modifyUser.setVersion(modifyUser.getVersion()+1);
        sessionService.setCurrentUser(modifyUser);
        return "redirect:/datasheet/mydata";
    }
}
