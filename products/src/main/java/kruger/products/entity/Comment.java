package kruger.products.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable{
	
	
	   private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue( strategy = GenerationType.IDENTITY)
	    private Long id;
//	    @Column(name = "rating", nullable = false,length = 100)
//	    private Integer rating;


	    @Column(name = "text", nullable = false,length = 250)
	    private String text;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private Product product;
}
