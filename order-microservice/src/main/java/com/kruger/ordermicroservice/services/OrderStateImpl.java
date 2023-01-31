package com.kruger.ordermicroservice.services;

import com.kruger.ordermicroservice.entities.OrderState;
import com.kruger.ordermicroservice.repositories.OrderStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderStateImpl implements OrderStateService{
    @Autowired
    private OrderStateRepository repo;
    @Override
    public List<OrderState> getAll() {
        return (List<OrderState> ) repo.findAll();
    }

    @Override
    public Optional<OrderState> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public OrderState save(OrderState orderState) {
        return repo.save(orderState);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);

    }
}
