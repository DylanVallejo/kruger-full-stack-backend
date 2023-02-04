package com.kruger.paymentmicroservice.service;

import com.kruger.paymentmicroservice.entity.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {

    public List<Payment> findAll();
    Payment save(Payment payment);
    public void delete(Long id);
    public Optional<Payment> findPaymentByid(Long id);
    public Optional<Payment> findByid(Long id);
}
