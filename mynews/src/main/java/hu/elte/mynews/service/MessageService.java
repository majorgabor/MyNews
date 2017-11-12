
package hu.elte.mynews.service;

import hu.elte.mynews.entity.Message;
import hu.elte.mynews.exception.UserException;
import java.util.Date;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import hu.elte.mynews.repository.MessageRepository;
import java.util.ArrayList;
import java.util.List;

@Service
@SessionScope
@Data
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserService userService;
    
    public Message sendMessage(long id, Message message) throws UserException {
        message.setDate(new Date());
        message.setUser(userService.getCurrentUser());
        if(userService.findUser(id) != null){
            message.setToUser(id);
            messageRepository.save(message);
            userService.sendMessage(message);
            return message;
        } else {
            throw new UserException();
        }
    }
    
    public List<Message> messageList() {
        Iterable<Message> allMessage = messageRepository.findAll();
        List<Message> myMessage = new ArrayList<Message>();
        for(Message message : allMessage){
            if(message.getToUser() == userService.getCurrentUser().getId()){
                myMessage.add(message);
            }
        }
        return myMessage;
    }
}
