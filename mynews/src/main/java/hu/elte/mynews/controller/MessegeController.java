
package hu.elte.mynews.controller;

import hu.elte.mynews.entity.Messege;
import hu.elte.mynews.repository.MessegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/messeges")
public class MessegeController {
    @Autowired
    private MessegeRepository messegeRepository;
    
    //@Role({User.Role.USER, User.Role.ADMIN})
    @GetMapping("/inbox")
    public String list(Model model){
        Iterable<Messege> Messeges = messegeRepository.findAll();
        model.addAttribute("messeges", Messeges);
        return "messeges";
    }
    
    //@Role({User.Role.USER, User.Role.ADMIN})
    @PostMapping("/send")
    public String addNews(@RequestBody Messege newMessege) {
        messegeRepository.save(newMessege);
        return "redirect:/news/timeline";
    }
}
