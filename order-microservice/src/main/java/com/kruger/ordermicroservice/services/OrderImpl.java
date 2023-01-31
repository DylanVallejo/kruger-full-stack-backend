package com.kruger.ordermicroservice.services;

import com.kruger.ordermicroservice.entities.Associate;
import com.kruger.ordermicroservice.entities.Order;
import com.kruger.ordermicroservice.entities.OrderState;
import com.kruger.ordermicroservice.repositories.AssociateRepository;
import com.kruger.ordermicroservice.repositories.OrderRepository;
import com.kruger.ordermicroservice.repositories.OrderStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderImpl  implements  OrderService{
    @Autowired
    private OrderRepository repo;
    @Autowired
    private OrderStateRepository orderStateRepository;

    @Autowired
    private AssociateRepository associateRepository;



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
        OrderState orderState = orderStateRepository.findById(order.getOrderState().getId()).get();
        Associate associate = associateRepository.findById(order.getAssociate().getId()).get();
        order.setAssociate(associate);
        order.setOrderState(orderState);
        return repo.save(order);
    }


    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
