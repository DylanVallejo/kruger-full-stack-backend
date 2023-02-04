package com.kruger.paymentmicroservice.client;

import com.kruger.paymentmicroservice.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "order-microservice", path = "api/order")
public interface OrderClient {
    @GetMapping("/{id}")
   ResponseEntity<Optional<Order>> getById(@PathVariable("id") Long id);
}
