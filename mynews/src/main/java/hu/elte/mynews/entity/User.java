
package hu.elte.mynews.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
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
public class User extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String name;
    
    @Column
    private Integer age;
    
    @Column
    private String city;
    
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    
    public enum Role {
        GUEST, USER, ADMIN
    }
    
    @JsonIgnore
    @OneToMany(targetEntity = News.class, cascade = CascadeType.ALL)
    private List<News> news;
    
    @JsonIgnore
    @OneToMany(targetEntity = Comment.class, cascade = CascadeType.ALL)
    private List<Comment> comment;
    
    @JsonIgnore
    @OneToMany(targetEntity = Report.class, cascade = CascadeType.ALL)
    private List<Report> report;
    
    @JsonIgnore
    @OneToMany(targetEntity = Message.class, cascade = CascadeType.ALL)
    private List<Message> sentMessage;
    
    @JsonIgnore
    @OneToMany(targetEntity = Message.class, cascade = CascadeType.ALL)
    private List<Message> gotMessage;

    @Override
    public String toString() {
        return "User: {id "+this.getId()+" version "+this.getVersion()+" name "+name+" email "+email+"}";
    }
}
