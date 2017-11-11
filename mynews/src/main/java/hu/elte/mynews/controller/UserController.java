
package hu.elte.mynews.controller;

import hu.elte.mynews.annotation.Role;
import hu.elte.mynews.entity.User;
import static hu.elte.mynews.entity.User.Role.ADMIN;
import static hu.elte.mynews.entity.User.Role.USER;
import hu.elte.mynews.exception.UserException;
import hu.elte.mynews.repository.UserRepository;
import hu.elte.mynews.service.SessionService;
import hu.elte.mynews.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    
    @PostMapping("/login")
    private ResponseEntity<User> login(@RequestBody User user) {
        try{
            User loginUser = userService.login(user);
            return ResponseEntity.ok(loginUser);
        } catch (UserException ex){
            return ResponseEntity.badRequest().build();
        }
    }
    
    @Role({ADMIN, USER})
    @PostMapping("/logout")
    private ResponseEntity<String> logout(@RequestBody User user){
        try{
            userService.logout();
            return ResponseEntity.ok("logged_out");
        } catch (UserException ex) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PostMapping("/register")
    private ResponseEntity<User> register(@RequestBody User user) {
        try{
            User newUser = userService.registrer(user, USER);
            return ResponseEntity.ok(newUser);
        } catch (UserException ex) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @Role({ADMIN, USER})
    @PutMapping("/modify/{id}")
    private ResponseEntity<User> modify(@PathVariable long id, @RequestBody User user) {
        try{
            User modifiedUser = userService.modify(id, user);
            return ResponseEntity.ok(modifiedUser);
        } catch (UserException ex) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    
    /*
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
        if(!newUser.getName().equals("") && !newUser.getEmail().equals("") && !newUser.getPassword().equals("")){
            newUser.setRole(User.Role.USER);
            userRepository.save(newUser);
        }
        return "redirect:/auth/login";
    }
    */
}
