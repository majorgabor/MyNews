
package hu.elte.mynews.service;

import hu.elte.mynews.entity.Message;
import hu.elte.mynews.entity.User;
import hu.elte.mynews.exception.UserException;
import java.util.Date;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import hu.elte.mynews.repository.MessageRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@SessionScope
@Data
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserService userService;
    
    public Message sendMessage(Message message) throws UserException {
        message.setDate(new Date());
        message.setFromUser(userService.findUser(userService.getCurrentUser().getId()));
        if(userService.findUser(message.getToUser().getId()) != null && userService.findUser(message.getToUser().getId()).getRole() != User.Role.GUEST){
            message.setToUser(userService.findUser(message.getToUser().getId()));
            messageRepository.save(message);
            userService.sentMessage(message);
            userService.gotMessage(message.getToUser().getId(), message);
            return message;
        } else {
            throw new UserException();
        }
    }
    
    public List<Message> myMessages() {
        Iterable<Message> allMessage = messageRepository.findAll();
        List<Message> myMessage = new ArrayList<>();
        for(Message message : allMessage){
            if(message.getToUser().equals(userService.getCurrentUser()) || message.getFromUser().equals(userService.getCurrentUser())){
                myMessage.add(message);
            }
        }
        return myMessage;
    }
    
    public Set<User> contactList() {
        Set<User> contacts = new HashSet();
        List<Message> myMessage = myMessages();
        for(Message message : myMessage){
            contacts.add(message.getToUser());
        }
        return contacts;
    }
    
    public List<Message> messagesFromId(long id) throws UserException {
        User from = userService.findUser(id);
        if(from != null){
            Iterable<Message> allMessage = messageRepository.findAll();
            List<Message> messagesFrom = new ArrayList<>();
            for(Message message : allMessage){
                if(message.getToUser().equals(from) || message.getFromUser().equals(from)){
                    messagesFrom.add(message);
                }
            }
            return messagesFrom;
        } else {
            throw new UserException();
        }
    }
}
