
package hu.elte.mynews.controller;

import hu.elte.mynews.entity.User;
import hu.elte.mynews.repository.UserRepository;
import hu.elte.mynews.service.SessionService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SessionService sessionService;
    
    @GetMapping("/login")
    public String getLogin(Model model){
        User loginUser = new User();
        User newUser = new User();
        model.addAttribute("loginUser", loginUser);
        model.addAttribute("newUser", newUser);
        return "login";
    }
    
    @PostMapping("/login")
    public String postLogin(@ModelAttribute User loginUser) {
        Optional<User> login = userRepository.findByEmailAndPassword(loginUser.getEmail(), loginUser.getPassword());
        if(login.isPresent()) {
            System.out.println("Login successful");
            System.out.println(login.get().toString());
            sessionService.setCurrentUser(login.get());
        } else {
            System.out.println("Login failed");
        }
        return "redirect:/auth/login";
    }
    
    @RequestMapping("/logout")
    public String logout() {
        sessionService.setCurrentUser(null);
        return "redirect:/auth/login";
    }
    
    @RequestMapping("/debug")
    public String debug() {
        System.out.println(sessionService.getCurrentUser());
        return "redirect:/auth/login";
    }
    
    @PostMapping("/registry")
    public String registry(@ModelAttribute User newUser) {
        newUser.setRole(User.Role.USER);
        userRepository.save(newUser);
        return "redirect:/auth/login";
    }
}
