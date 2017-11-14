
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
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Message extends BaseEntity{
    
    @Column(nullable = false)
    private String text;
    
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    
    @JoinColumn(referencedColumnName = "id")
    @ManyToOne(targetEntity = User.class)
    private User fromUser;
    
    @JoinColumn(referencedColumnName = "id")
    @ManyToOne(targetEntity = User.class)
    private User toUser;
}
