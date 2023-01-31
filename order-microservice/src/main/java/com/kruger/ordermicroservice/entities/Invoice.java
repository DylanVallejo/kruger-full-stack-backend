package com.kruger.ordermicroservice.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double cost;
}
