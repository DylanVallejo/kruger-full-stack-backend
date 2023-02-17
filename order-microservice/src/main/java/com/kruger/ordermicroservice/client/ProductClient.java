package com.kruger.ordermicroservice.client;

import com.kruger.ordermicroservice.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;

@FeignClient(name = "products", path = "api/product")
public interface ProductClient {

    @GetMapping("/{id}")
    ResponseEntity<Optional<Product>> getById(@PathVariable("id") Long id);



}


