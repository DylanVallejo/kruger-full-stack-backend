package kruger.products.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kruger.products.Audit.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@Entity
@Table(name = "products")
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product extends Auditable<String> implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotNull(message="Debes agregaar un nombre al producto")
    @NonNull
    private String productName;

    private String description;
    
    private Long price;
    
//  private String category;
    
    private double height;
    
    private double width;
    
    private Long bestSelling; 
    
    private  Boolean itsInOffers;

    private  Long discount;
    
    private Long stock;
    
/*
    @Temporal(TemporalType.DATE)
    @Column(name = "create_at")
    private Date createAt;

  
   */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments;

}
   