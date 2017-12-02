
package hu.elte.mynews.controller;

import hu.elte.mynews.annotation.Role;
import hu.elte.mynews.entity.Message;
import hu.elte.mynews.entity.User;
import static hu.elte.mynews.entity.User.Role.ADMIN;
import static hu.elte.mynews.entity.User.Role.USER;
import hu.elte.mynews.exception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hu.elte.mynews.service.MessageService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;
    
    @Role({USER, ADMIN})
    @GetMapping("/mymessages")
    private ResponseEntity<List<Message>> messagesList(){
        return ResponseEntity.ok(messageService.myMessages());
    }
    
    @Role({USER, ADMIN})
    @PostMapping("/send")
    private ResponseEntity<Message> sendMessage(@RequestBody Message newMessage) {
        try{
            return ResponseEntity.ok(messageService.sendMessage(newMessage));
        } catch (UserException ex){
            return ResponseEntity.badRequest().build();
        }
    }
}
