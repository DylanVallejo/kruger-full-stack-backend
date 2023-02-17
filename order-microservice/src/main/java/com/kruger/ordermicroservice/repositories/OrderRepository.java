package com.kruger.ordermicroservice.repositories;


import com.kruger.ordermicroservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
