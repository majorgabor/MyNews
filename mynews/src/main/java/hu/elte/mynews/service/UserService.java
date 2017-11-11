
package hu.elte.mynews.service;

import hu.elte.mynews.entity.News;
import hu.elte.mynews.entity.User;
import hu.elte.mynews.exception.UserException;
import hu.elte.mynews.repository.UserRepository;
import java.util.Date;
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
            currentUser = modifiedUser;
            return modifiedUser;
        } else {
            throw new UserException();
        }
    }
    
    public User newNews(News news) throws UserException {
        if(currentUser != null){
            currentUser.getNews().add(news);
            userRepository.save(currentUser);
        } else {
            throw new UserException();
        }
        return currentUser;
    }
}