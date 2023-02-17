package com.kruger.ordermicroservice.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kruger.ordermicroservice.audit.Auditable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "order_states")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class OrderState extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "orderState", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Set<Order> orders;
}
