package com.kruger.ordermicroservice.services;

import com.kruger.ordermicroservice.entities.Order;
import com.kruger.ordermicroservice.entities.OrderProduct;

import java.util.List;
import java.util.Optional;

public interface OrderProductService {

    List<OrderProduct> getAll();

    Optional<OrderProduct> findById(Long id);

    OrderProduct save(OrderProduct order);

    void delete(Long id);

    OrderProduct getOrder(Long id);
}
