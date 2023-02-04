package com.kruger.ordermicroservice.entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kruger.ordermicroservice.audit.Auditable;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Data
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class)
public class Order extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_states_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private OrderState orderState;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "associates_id" )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Associate associate;


    private int shipping;


    private int cost;

    //Cart info. Debería incluir el valor del carrito
    // El carrito está compuesto por el product item y el numero de unidades

    // Shipping. Sugiero que sea una tarifa plana, para no complicarnos.
    //una orden tienen muchos detalles
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderProduct> items;

    @Column(name = "total_amount")
    private Double totalAmount;

//maestro detalle

    //primero orden cabecera
    //order product detalles
}
