package com.kruger.paymentmicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;
    private OrderState orderState;
    private Associate associate;
    private int shipping;
    private int cost;
    private Double totalAmount;
}
