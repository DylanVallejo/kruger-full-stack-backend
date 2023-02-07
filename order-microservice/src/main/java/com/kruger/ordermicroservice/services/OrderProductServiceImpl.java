package com.kruger.ordermicroservice.services;

import com.kruger.ordermicroservice.client.ProductClient;
import com.kruger.ordermicroservice.entities.OrderProduct;
import com.kruger.ordermicroservice.models.Product;
import com.kruger.ordermicroservice.repositories.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderProductServiceImpl implements OrderProductService{
    @Autowired
    OrderProductRepository orderProductRepository;
    @Autowired
    private ProductClient productClient;

    @Override
    public List<OrderProduct> getAll() {
        return orderProductRepository.findAll();
    }

    @Override
    public Optional<OrderProduct> findById(Long id) {

        return Optional.empty();
    }

    @Override
    public OrderProduct save(OrderProduct order) {
         Product product= productClient.getById(order.getProductId()).getBody().get();
         order.setPrice(product.getPrice());
         order.setProductName(product.getProductName());
         order.setSubtotal(product.getPrice() * order.getQuantity());
         order.setStatus(true);
        return orderProductRepository.save(order);
    }

    @Override
    public void delete(Long id) {
        orderProductRepository.deleteById(id);

    }

    @Override
    public OrderProduct getOrder(Long id) {
        return null;
    }
}
