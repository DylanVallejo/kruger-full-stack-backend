package com.kruger.ordermicroservice.services;

import com.kruger.ordermicroservice.client.ProductClient;
import com.kruger.ordermicroservice.entities.Associate;
import com.kruger.ordermicroservice.entities.Order;
import com.kruger.ordermicroservice.entities.OrderProduct;
import com.kruger.ordermicroservice.entities.OrderState;
import com.kruger.ordermicroservice.models.Product;
import com.kruger.ordermicroservice.repositories.AssociateRepository;
import com.kruger.ordermicroservice.repositories.OrderRepository;
import com.kruger.ordermicroservice.repositories.OrderStateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderImpl  implements  OrderService{

//    necesitmaos autowired pero con autowired no levanta requiere un bean
    ProductClient productClient;

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderStateRepository orderStateRepository;

    @Autowired
    private AssociateRepository associateRepository;



    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order save(Order order) {
        OrderState orderState = orderStateRepository.findById(order.getOrderState().getId()).get();
        Associate associate = associateRepository.findById(order.getAssociate().getId()).get();
        order.setAssociate(associate);
        order.setOrderState(orderState);
        return orderRepository.save(order);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }


//agreagar un producto a la orden item
    @Override
    public Order getOrder(Long id){
        Order orderDB = orderRepository.findById(id).orElse(null);
        if(orderDB != null){
            List<OrderProduct> listItems =  orderDB.getItems().stream().map(orderItem ->{
                Product product = productClient.getById(orderItem.getProductId()).getBody().get();
                orderItem.setProduct(product);
                return orderItem;
            }).collect(Collectors.toList());
            orderDB.setItems(listItems);
        }
        return orderDB;
    }

}
