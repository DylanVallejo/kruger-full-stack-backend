package com.kruger.ordermicroservice.controllers;


import com.kruger.ordermicroservice.entities.Order;
import com.kruger.ordermicroservice.entities.OrderState;
import com.kruger.ordermicroservice.models.Product;
import com.kruger.ordermicroservice.services.OrderService;
import com.kruger.ordermicroservice.services.OrderStateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Tag(name = " Order Controller", description = "Crud operations for Orders.")
@RestController
@RequestMapping("api/order")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderStateService orderStateService;

    @Tag(name = "Order find all.")
    @Operation(summary = "Retrieves orders", description = "Provides a list of all orders.")
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


    @PutMapping("/order-state/{id}")
    public ResponseEntity<Order> update(@RequestBody Order order, @PathVariable("id") Long id ){
//        service.findById(order.getOrderState().getId()).get();
        OrderState orderState = orderStateService.findById(order.getOrderState().getId()).get();
        Order order1 = orderService.findById(id).get();
        order1.setOrderState(orderState);

//        Optional< Category> category= categoryService.findCategoryByid(product.getCategory().getId());
//        Product product1= productService.findProductoByid(id).get();
//        product1.setCategory(category.get());
//        product1.setProductName(product.getProductName());
//        product1.setDescription(product.getDescription());
//        product1.setPrice(product.getPrice());
//        product1.setStock(product.getStock());
//        product1.setItsInOffers(product.getItsInOffers());
//        product1.setLastModifiedDate(new Date());
        Order orderNew = orderService.save(order1);
        return ResponseEntity.ok(orderNew);
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
