package com.kruger.ordermicroservice.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kruger.ordermicroservice.audit.Auditable;
import com.kruger.ordermicroservice.models.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

@Data
@Entity
@Table(name="order_product")
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class OrderProduct extends Auditable<String> implements Serializable {

//realacion varios  detalles tienen una orden
    @ManyToOne
    @JsonIgnore
    private Order order;
    //@Transient
   // Product product;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private Boolean status;
    private Long productId;
    private Double price;
    private Long quantity;
    private Double subtotal;

}
