package com.kruger.ordermicroservice.entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date created;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_states", referencedColumnName = "id")
    private OrderState state;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "associates", referencedColumnName = "id")
    private Associate associate;


    @NotNull(message = "Shipping is mandatory")
    @NotEmpty(message = "Shipping shouldn't be empty")
    private int shipping;

    @Min(value = 0, message = "Shouldn be greater than 0")
    private int cost;

    //Cart info. Debería incluir el valor del carrito
    // El carrito está compuesto por el product item y el numero de unidades


    // Shipping. Sugiero que sea una tarifa plana, para no complicarnos.




}
