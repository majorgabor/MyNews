
package hu.elte.mynews.controller;

import hu.elte.mynews.annotation.Role;
import hu.elte.mynews.entity.User;
import static hu.elte.mynews.entity.User.Role.ADMIN;
import hu.elte.mynews.exception.UserException;
import hu.elte.mynews.service.ReportService;
import hu.elte.mynews.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private ReportService reportService;
    
    @Role({ADMIN})
    @GetMapping("/reports")
    public ResponseEntity listReports(){
        return ResponseEntity.ok(reportService.listReports());
    }
    
    @Role({ADMIN})
    @PostMapping("/newadmin")
    public ResponseEntity<User> newadmin(@RequestBody User newUser) {
        try{
            User newAdmin = userService.registrer(newUser, ADMIN);
            return ResponseEntity.ok(newAdmin);
        } catch (UserException ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}
