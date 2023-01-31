package com.kruger.ordermicroservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "associates")
@Data
@AllArgsConstructor @NoArgsConstructor

public class Associate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotEmpty(message = "Name shouldn't be empty")
//    @NotNull(message = "Name shouldn't be null")
    private String name;

//    @NotEmpty(message = "Address shouldn't be empty")
//    @NotNull(message = "Address shouldn't be null")
    private String address;

    private Boolean associateStatus;
    @JsonIgnore
    @OneToMany(mappedBy = "associate", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Set<Order> orders;
}
