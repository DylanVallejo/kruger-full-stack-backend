package com.kruger.paymentmicroservice.controller;

import com.kruger.paymentmicroservice.entity.Payment;
import com.kruger.paymentmicroservice.service.PaymentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@Tag(name = "Payment Controller", description = "Crud operations for payment.")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping()
    public ResponseEntity<List<Payment>> findAll(){
        List<Payment> products = paymentService.findAll();
        if(products.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(products);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Payment>> getById(@PathVariable("id") Long id){
        Optional<Payment> payment = paymentService.findPaymentByid(id);
        if(payment==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(payment);
    }

    @PostMapping()
    public ResponseEntity<Payment> save(@RequestBody Payment payment){

       // Optional<Category> category= categoryService.findCategoryByid(payment.getCategory().getId());
        // payment.setCategory(category.get());
        Payment productNew = paymentService.save(payment);
        return ResponseEntity.ok(productNew);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Payment> update(@RequestBody Payment payment,@PathVariable("id") Long id ){
        /*Optional< Category> category= categoryService.findCategoryByid(payment.getCategory().getId());
        Payment product1= paymentService.findProductoByid(id).get();
        product1.setCategory(category.get());
        product1.setProductName(payment.getProductName());
        product1.setDescription(payment.getDescription());
        product1.setPrice(payment.getPrice());
        product1.setStock(payment.getStock());
        product1.setItsInOffers(payment.getItsInOffers());
        product1.setLastModifiedDate(new Date());*/
        Payment productNew = paymentService.save(payment);
        return ResponseEntity.ok(productNew);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public void delete(@PathVariable Long id) {
        paymentService.delete(id);
    }



}
