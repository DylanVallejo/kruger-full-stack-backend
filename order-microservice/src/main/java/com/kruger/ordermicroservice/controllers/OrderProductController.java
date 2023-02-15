package com.kruger.ordermicroservice.controllers;


import com.kruger.ordermicroservice.entities.Order;
import com.kruger.ordermicroservice.entities.OrderProduct;
import com.kruger.ordermicroservice.entities.OrderState;
import com.kruger.ordermicroservice.repositories.OrderProductRepository;
import com.kruger.ordermicroservice.repositories.OrderRepository;
import com.kruger.ordermicroservice.services.OrderProductServiceImpl;
import com.kruger.ordermicroservice.services.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Tag(name = "Order Product Controller", description = "Crud operations for Order Product.")
@RestController
@RequestMapping("/api/orderproduct")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class OrderProductController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderProductServiceImpl orderProductService;

    @GetMapping("/order/detalles")
    public List<OrderProduct> getAll(){
        return orderProductService.getAll();
    }


//    agregar un producto a una order
    @PostMapping("/orderproduct/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderProduct save(@PathVariable( "id") Long id, @RequestBody OrderProduct orderProduct){
        Order order = orderService.findById(id).get();
        orderProduct.setOrder(order);
        return orderProductService.save(orderProduct);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public void delete(@PathVariable Long id) {
        orderProductService.delete(id);
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
