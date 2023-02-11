package com.kruger.ordermicroservice.services;

import com.kruger.ordermicroservice.entities.Associate;
import com.kruger.ordermicroservice.entities.Order;
import com.kruger.ordermicroservice.entities.OrderProduct;
import com.kruger.ordermicroservice.entities.OrderState;
import com.kruger.ordermicroservice.repositories.AssociateRepository;
import com.kruger.ordermicroservice.repositories.OrderProductRepository;
import com.kruger.ordermicroservice.repositories.OrderRepository;
import com.kruger.ordermicroservice.repositories.OrderStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderImpl  implements  OrderService{

//    necesitmaos autowired pero con autowired no levanta requiere un bean
   // ProductClient productClient;

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderStateRepository orderStateRepository;

    @Autowired
    private AssociateRepository associateRepository;

    @Autowired
    private OrderProductRepository orderProductRepository;



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

//        jonathan
        List< OrderProduct > detalles = order.getItems();
        order.setItems(null);
//        jonathan
        System.out.println( detalles.isEmpty());


         OrderState  orderState = orderStateRepository.findById(order.getOrderState().getId()).get();
         Associate associate = associateRepository.findById(order.getAssociate().getId()).get();
        order.setAssociate(associate);
        order.setOrderState(orderState);
//        return orderRepository.save(order);

//        jona
        orderRepository.save(order);

        for (OrderProduct detalle:detalles) {

            detalle.setOrder(order);
            detalle.setSubtotal(detalle.getQuantity()*detalle.getPrice());
        }
        orderProductRepository.saveAll(detalles);
        order.setItems(detalles);
        return order;

//        jonathan

    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }


//agreagar un producto a la orden item
    /*
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
*/
}
