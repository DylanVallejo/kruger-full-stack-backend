package com.kruger.ordermicroservice.controllers;


import com.kruger.ordermicroservice.entities.Order;
import com.kruger.ordermicroservice.entities.OrderProduct;
import com.kruger.ordermicroservice.entities.OrderState;
import com.kruger.ordermicroservice.repositories.OrderProductRepository;
import com.kruger.ordermicroservice.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class OrderProductController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderProductRepository orderProductRepository;

    @GetMapping("/order/detalles")
    public List<OrderProduct> getAll(){
        return orderProductRepository.findAll();
    }


//    agregar un producto a una order
    @PostMapping("/order/{id}/detalle")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderProduct save(@PathVariable( "id") Long id, @RequestBody OrderProduct detalle){
        Order order = orderRepository.findById(id).get();
        order.getItems().add(detalle);
//        order.setItems(detalle);
        return orderProductRepository.save(detalle);
    }

//    @DeleteMapping("/order/detalles\"{id}")
//    public ResponseEntity<?> delete(@PathVariable Long id){
//        Optional<OrderState> o = orderProductRepository.findById(id);
//        if(o.isPresent()){
//            orderProductRepository.delete(id);
//            return ResponseEntity.noContent().build();
//        }else{
//            return ResponseEntity.notFound().build();
//        }
//    }

}
