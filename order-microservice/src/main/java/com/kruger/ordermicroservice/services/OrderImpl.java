package com.kruger.ordermicroservice.services;

import com.kruger.ordermicroservice.entities.Order;
import com.kruger.ordermicroservice.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderImpl  implements  OrderService{
    @Autowired
    private OrderRepository repo;
    @Override
    public List<Order> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Order save(Order order) {
        return repo.save(order);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
