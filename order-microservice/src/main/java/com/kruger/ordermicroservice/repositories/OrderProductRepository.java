package com.kruger.ordermicroservice.repositories;

import com.kruger.ordermicroservice.entities.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {


}
