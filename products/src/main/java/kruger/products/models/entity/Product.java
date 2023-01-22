package kruger.products.models.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/*import javax.persistence.Temporal;
import javax.persistence.TemporalType;*/
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

	
	
@Entity
@Table(name = "products")
@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Product implements Serializable{

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
    
    private Long heigth;
    
    private Long weigth; 
    
    private Long bestSelling; 
    
    private  Boolean itsInOffers;

    private  Long discount;
    
    private Long stock;
    
/*
    @Temporal(TemporalType.DATE)
    @Column(name = "create_at")
    private Date createAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
  
   
    @OneToMany(mappedBy = "products", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments; */

}
   

