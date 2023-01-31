package com.kruger.ordermicroservice.repositories;


import com.kruger.ordermicroservice.entities.OrderState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStateRepository extends JpaRepository<OrderState, Long> {
}
