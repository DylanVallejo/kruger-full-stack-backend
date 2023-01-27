package kruger.products.entity;
import java.io.Serializable;

import java.util.Set;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kruger.products.Audit.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "category")
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category extends Auditable<String> implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

  
    private String description;

    /*  @Temporal(TemporalType.DATE)
    @Column(name = "create_at")
    private Date createAt;

    *///
    @JsonIgnore
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Set<Product> products;
}
