
package hu.elte.mynews.controller;

import hu.elte.mynews.annotation.Role;
import hu.elte.mynews.entity.Report;
import hu.elte.mynews.entity.User;
import hu.elte.mynews.repository.ReportRepository;
import hu.elte.mynews.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReportRepository reportRepository;
    
    @Role({ User.Role.ADMIN})
    @GetMapping("")
    public String admin(Model model) {
        User newUser = new User();
        model.addAttribute("newUser", newUser);
        return "admin";
    }
    
    @Role({ User.Role.ADMIN})
    @GetMapping("/reports")
    public String listReport(Model model){
        Iterable<Report> list = reportRepository.findAll();
        model.addAttribute("reports", list);
        return "reports";
    }
    
    /*@Role({ User.Role.ADMIN})
    @PostMapping("/newadmin")
    public String newadmin(@ModelAttribute User newUser) {
        if(!newUser.getName().equals("") && !newUser.getEmail().equals("") && !newUser.getPassword().equals("")){
            newUser.setRole(User.Role.ADMIN);
            userRepository.save(newUser);
        }
        return "redirect:/admin/reports";
    }*/
    
    @PostMapping("/newadmin")
    public String newadmin(@RequestBody User newUser) {
        userRepository.save(newUser);
        return "redirect:/admin/reports";
    }
}
