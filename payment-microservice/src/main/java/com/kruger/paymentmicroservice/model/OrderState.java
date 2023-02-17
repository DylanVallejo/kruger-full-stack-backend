package com.kruger.paymentmicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderState {
    private Long id;
    private String name;
    private String description;

}
