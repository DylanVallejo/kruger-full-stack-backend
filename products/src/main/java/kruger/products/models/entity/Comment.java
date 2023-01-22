package kruger.products.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
