package com.kruger.ordermicroservice.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "order_states")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "orderState", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Set<Order> orders;
}
