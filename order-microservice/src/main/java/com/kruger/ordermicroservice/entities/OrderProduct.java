package com.kruger.ordermicroservice.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kruger.ordermicroservice.models.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="order_product")
@AllArgsConstructor
@NoArgsConstructor
public class OrderProduct {

//realacion varios  detalles tienen una orden
    @ManyToOne
    @JsonIgnore
    private Order order;
    @Transient
    Product product;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean status;
    private Long productId;
    private Double price;
    private Long quantity;

}
