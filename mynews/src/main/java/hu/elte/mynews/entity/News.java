
package hu.elte.mynews.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @Column(nullable = false)
    private String text;
    
    @Column(nullable = true)
    private Integer likes = 0;
    
    @Column(nullable = true)
    private Integer dislikes = 0;
    
    @Column(nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date = new Date();
}
