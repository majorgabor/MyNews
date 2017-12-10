
package hu.elte.mynews.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class News extends BaseEntity{
    @Lob
    @Column(nullable = false)
    private String text;
    
    @Column(nullable = false)
    private Integer likes;
    
    @JsonIgnore
    @ManyToMany(mappedBy="likedNews")
    private Set<User> likerUser;
    
    @Column(nullable = false)
    private Integer dislikes;
    
    @JsonIgnore
    @ManyToMany(mappedBy="dislikedNews")
    private Set<User> dislikerUser;
    
    @Column(nullable = false)
    private Boolean reported;
    
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    
    @JoinColumn(referencedColumnName = "id")
    @ManyToOne(targetEntity = User.class)
    private User user;
    
    @JsonIgnore
    @OneToMany(targetEntity = Comment.class, cascade = CascadeType.ALL)
    private List<Comment> comment;

    @Override
    public String toString() {
        return "News: {id: "+this.getId()+" version "+this.getVersion()+" text "+text+"}";
    }
}
