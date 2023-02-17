package kruger.products.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kruger.products.Audit.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

@Entity
@Table(name = "comment")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends Auditable<String> implements Serializable{


	   private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue( strategy = GenerationType.IDENTITY)
	    private Long id;
//	    @Column(name = "rating", nullable = false,length = 100)
//	    private Integer rating;


	    @Column(name = "text", nullable = false,length = 250)
	    private String text;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	@JsonIgnore
	private Product product;
}
