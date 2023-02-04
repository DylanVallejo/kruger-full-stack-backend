package com.kruger.ordermicroservice.entities;

import com.kruger.ordermicroservice.audit.Auditable;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Invoice  extends Auditable<String> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double cost;
}
