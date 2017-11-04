
package hu.elte.mynews.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Comment extends BaseEntity {
    @Column(nullable=false)
    private String text;
    
    @Column(nullable = false)
    private Integer likes = 0;
    
    @Column(nullable = false)
    private Integer dislikes = 0;
    
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date = new Date();
    
    @JoinColumn
    @ManyToOne(targetEntity = News.class)
    private News news;
    
    @JoinColumn
    @ManyToOne(targetEntity = User.class)
    private User user;

    @Override
    public String toString() {
        return "Comment";
    }
}
