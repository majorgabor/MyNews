
package hu.elte.mynews.controller;

import hu.elte.mynews.annotation.Role;
import hu.elte.mynews.entity.Comment;
import static hu.elte.mynews.entity.User.Role.ADMIN;
import static hu.elte.mynews.entity.User.Role.USER;
import hu.elte.mynews.exception.NewsException;
import hu.elte.mynews.exception.UserException;
import hu.elte.mynews.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;
    
    @GetMapping
    private ResponseEntity<Iterable<Comment>> list(){
        return ResponseEntity.ok(commentService.list());
    }
    
    @Role({USER, ADMIN})
    @PutMapping("/{id}")
    private ResponseEntity<Comment> newComment(@PathVariable long id, @RequestBody Comment comment){
        try{
            return ResponseEntity.ok(commentService.newComment(id, comment));
        } catch (NewsException ex) {
            System.out.println("******** news ex:" + ex.toString());
            return ResponseEntity.badRequest().build();
        } catch (UserException ex) {
            System.out.println("******** user ex:" + ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }
}
