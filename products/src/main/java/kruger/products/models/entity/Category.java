package kruger.products.models.entity;
import java.io.Serializable;
/*import java.sql.Date;*/
import java.util.Set;

import javax.persistence.CascadeType;
/*import javax.persistence.Column;*/
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/*
import javax.persistence.Temporal;
import javax.persistence.TemporalType;*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

  
    private String description;

    /*  @Temporal(TemporalType.DATE)
    @Column(name = "create_at")
    private Date createAt;
   

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Set<Product> products;
    *///
}
