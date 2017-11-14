
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
    private Integer likes;
    
    @Column(nullable = false)
    private Integer dislikes;
    
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    
    @JoinColumn(referencedColumnName = "id")
    @ManyToOne(targetEntity = User.class)
    private User user;
    
    @JoinColumn(referencedColumnName = "id")
    @ManyToOne(targetEntity = News.class)
    private News news;

    @Override
    public String toString() {
        return "Comment: {id: "+this.getId()+" version "+this.getVersion()+" text "+text+"}";
    }
}
