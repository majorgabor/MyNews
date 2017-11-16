
package hu.elte.mynews.service;

import hu.elte.mynews.entity.Comment;
import hu.elte.mynews.entity.Message;
import hu.elte.mynews.entity.News;
import hu.elte.mynews.entity.User;
import hu.elte.mynews.exception.UserException;
import hu.elte.mynews.repository.UserRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
@Data
public class UserService {
    
    private User currentUser;
    
    @Autowired
    private UserRepository userRepository;
    
    public User login(User user) throws UserException {
        Optional<User> loginUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if(loginUser.isPresent()){
            currentUser = loginUser.get();
            return loginUser.get();
        } else {
            throw new UserException();
        }
    }
    
    public void logout() throws UserException {
        if (currentUser == null){
            throw new UserException();
        }
        currentUser = null;
    }
    
    public User registrer(User user, User.Role role) throws UserException {
        user.setDate(new Date());
        user.setRole(role);
        if( user.getName().length()<6 || user.getPassword().length()<6
            || !user.getEmail().matches("[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-z]+")
            || userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new UserException();
        }
        currentUser = userRepository.save(user);
        return user;
    }
    
    public User modify(long id, User user) throws UserException {
        if(currentUser == null) {
            throw new UserException();
        }
        User modifiedUser = userRepository.findOne(id);
        if(modifiedUser != null){
            if(user.getName().length() > 5) modifiedUser.setName(user.getName());
            if(user.getPassword().length() > 5) modifiedUser.setPassword(user.getPassword());
            modifiedUser.setCity(user.getCity());
            modifiedUser.setAge(user.getAge());
            modifiedUser.setNews(user.getNews());
            userRepository.save(modifiedUser);
            currentUser = userRepository.findOne(currentUser.getId());
            return currentUser;
        } else {
            throw new UserException();
        }
    }
    
    public User newNews(News news) throws UserException {
        User newNewsUser = userRepository.findOne(currentUser.getId());
        if(newNewsUser != null){
            newNewsUser.getNews().add(news);
            userRepository.save(newNewsUser);
            currentUser = newNewsUser;
            return newNewsUser;
        } else {
            throw new UserException();
        }
    }
    
    public User newComment(Comment comment) throws UserException {
        User newCommentUser = userRepository.findOne(currentUser.getId());
        if(newCommentUser != null){
            newCommentUser.getComment().add(comment);
            userRepository.save(newCommentUser);
            currentUser = newCommentUser;
            return newCommentUser;
        } else {
            throw new UserException();
        }
    }
    
    public User profile(long id) throws UserException {
        User user = userRepository.findOne(id);
        if(user != null){
            return user;
        } else {
            throw new UserException();
        }
    }
    
    public User findUser(long id){
        return userRepository.findOne(id);
    }
    
    public User sentMessage(Message message) throws UserException {
        User senderUser = userRepository.findOne(currentUser.getId());
        if(senderUser != null){
            senderUser.getSentMessage().add(message);
            userRepository.save(senderUser);
            currentUser = senderUser;
            return senderUser;
        } else {
            throw new UserException();
        }
    }
    
    public User gotMessage(long id, Message message) throws UserException {
        User reciverUser = userRepository.findOne(id);
        if(reciverUser != null){
            reciverUser.getGotMessage().add(message);
            userRepository.save(reciverUser);
            currentUser = reciverUser;
            return reciverUser;
        } else {
            throw new UserException();
        }
    }
    
    public User deleteUser(long id) throws UserException {
        User deleteUser = userRepository.findOne(id);
        if(deleteUser != null && !deleteUser.equals(currentUser)){
            deleteUser.setEmail("deleted_user");
            deleteUser.setName("deleted_user");
            deleteUser.setAge(null);
            deleteUser.setCity(null);
            deleteUser.setPassword("");
            deleteUser.setRole(User.Role.GUEST);
            userRepository.save(deleteUser);
            return deleteUser;
        } else {
            throw new UserException();
        }
    }
    
    public User deleteNews(long userId, News news) throws UserException{
        User newsUser  = userRepository.findOne(userId);
        if(newsUser != null){
            newsUser.getNews().remove(news);
            userRepository.save(newsUser);
            return newsUser;
        } else {
            throw new UserException();
        }
    }
    
    public User deleteComment(long userId, Comment comment) throws UserException {
        User commentedUser = userRepository.findOne(userId);
        if(commentedUser != null){
            commentedUser.getComment().remove(comment);
            userRepository.save(commentedUser);
            return commentedUser;
        } else {
            throw new UserException();
        }
    }
}