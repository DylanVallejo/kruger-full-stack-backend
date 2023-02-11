package com.kruger.ordermicroservice.controllers;


import com.kruger.ordermicroservice.entities.Order;
import com.kruger.ordermicroservice.models.Product;
import com.kruger.ordermicroservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/order")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAll(){
        return orderService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order){
//        jonatan
            System.out.println(order.getItems().isEmpty());
//        j
        return orderService.save(order);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Order>> getById(@PathVariable("id") Long id){
        Optional<Order> order = orderService.findById(id);
        if(order==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(order);
    }

//    crear una orden
/*
    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id") long id) {
        Order Order  = orderService.getOrder(id);
        if (null == Order) {
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(Order);
    }
*/

}
