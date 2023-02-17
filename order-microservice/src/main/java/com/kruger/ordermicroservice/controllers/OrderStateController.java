package com.kruger.ordermicroservice.controllers;


import com.kruger.ordermicroservice.entities.Order;
import com.kruger.ordermicroservice.entities.OrderState;
import com.kruger.ordermicroservice.services.OrderStateService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Tag(name = "State Order Controller", description = "Crud operations for Order State.")
@RestController
@RequestMapping("api/state")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class OrderStateController {
    @Autowired
    private OrderStateService service;

    @GetMapping("/order-state")
    public List<OrderState> getAll(){
        return service.getAll();
    }

    @PostMapping("/order-state")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderState save(@RequestBody OrderState state){
        return service.save(state);
    }

//    @PutMapping("/order-state/{id}")
//    public ResponseEntity<Order> update(@RequestBody Order order, @PathVariable("id") Long id ){
////        service.findById(order.getOrderState().getId()).get();
//        OrderState orderState = service.findById(order.getOrderState().getId()).get();
//        Order order = service
//
////        Optional< Category> category= categoryService.findCategoryByid(product.getCategory().getId());
////        Product product1= productService.findProductoByid(id).get();
////        product1.setCategory(category.get());
////        product1.setProductName(product.getProductName());
////        product1.setDescription(product.getDescription());
////        product1.setPrice(product.getPrice());
////        product1.setStock(product.getStock());
////        product1.setItsInOffers(product.getItsInOffers());
////        product1.setLastModifiedDate(new Date());
////        Product productNew = productService.save(product1);
////        return ResponseEntity.ok(productNew);
//    }

    @DeleteMapping("/order-state/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<OrderState> o = service.findById(id);
        if(o.isPresent()){
            service.delete(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
