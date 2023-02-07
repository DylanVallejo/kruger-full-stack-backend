package com.kruger.dashboardmicroservice.entity;

import com.kruger.dashboardmicroservice.audit.Auditable;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

@Entity
@Data
@Table(name = "company")
@EntityListeners(AuditingEntityListener.class)
public class Company extends Auditable<String> implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;
    private String address;
    private String city;
    private String phone;
    private String cell_phone;
    private String email;
    @Lob
    private String mission;
    @Lob
    private String vision;

}
