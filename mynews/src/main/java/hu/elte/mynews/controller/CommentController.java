
package hu.elte.mynews.controller;

import hu.elte.mynews.annotation.Role;
import hu.elte.mynews.entity.Comment;
import static hu.elte.mynews.entity.User.Role.ADMIN;
import static hu.elte.mynews.entity.User.Role.USER;
import hu.elte.mynews.exception.CommentException;
import hu.elte.mynews.exception.NewsException;
import hu.elte.mynews.exception.UserException;
import hu.elte.mynews.service.CommentService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;
    
    @GetMapping("/{id}")
    private ResponseEntity<List<Comment>> listCommentToNews(@PathVariable long id){
        return ResponseEntity.ok(commentService.listCommentToNews(id));
    }
    
    @GetMapping("/all")
    private ResponseEntity<Iterable<Comment>> getAllComment(){
        return ResponseEntity.ok(commentService.getAllComment());
    }
    
    @Role({USER, ADMIN})
    @PutMapping("/addcomment/{id}")
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
    
    @Role({USER, ADMIN})
    @PutMapping("/{rate}/{id}")
    private ResponseEntity<Comment> rate(@PathVariable String rate, @PathVariable long id){
        try{
            return ResponseEntity.ok(commentService.rate(id, rate));
        } catch (CommentException ex) {
            return ResponseEntity.badRequest().build();
        } catch (UserException ex) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @Role({ADMIN})
    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Comment> deleteComment(@PathVariable long id){
        try {
            return ResponseEntity.ok(commentService.deleteComment(id));
        } catch (CommentException ex) {
            return ResponseEntity.badRequest().build();
        } catch (NewsException ex) {
            return ResponseEntity.badRequest().build();
        } catch (UserException ex) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @Role({USER, ADMIN})
    @PutMapping("/report/{id}")
    private ResponseEntity<Comment> reportComment( @PathVariable long id){
        try{
            return ResponseEntity.ok(commentService.reportComment(id));
        } catch (CommentException ex) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @Role({ADMIN})
    @PutMapping("/deletereport/{id}")
    private ResponseEntity<Comment> deleteReportComment( @PathVariable long id){
        try{
            return ResponseEntity.ok(commentService.deleteReportComment(id));
        } catch (CommentException ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}
