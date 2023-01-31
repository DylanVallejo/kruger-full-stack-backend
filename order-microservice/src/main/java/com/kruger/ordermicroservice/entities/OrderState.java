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

//    @NotEmpty(message = "Name shouldn't be empty")
//    @NotNull(message = "Name shouldn't be null")
    private String name;

//    @NotEmpty(message = "Address shouldn't be empty")
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "state", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Set<Order> orders;


//    public Long getId() {
//        return id;
//    }
//
//    public List<Order> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(List<Order> orders) {
//        this.orders = orders;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
}
