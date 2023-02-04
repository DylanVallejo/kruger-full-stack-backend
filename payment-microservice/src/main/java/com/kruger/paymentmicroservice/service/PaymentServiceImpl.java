package com.kruger.paymentmicroservice.service;

import com.kruger.paymentmicroservice.client.OrderClient;
import com.kruger.paymentmicroservice.entity.Payment;
import com.kruger.paymentmicroservice.model.Order;
import com.kruger.paymentmicroservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderClient orderClient;
    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment save(Payment payment) {
        Order order= orderClient.getById(payment.getOrderId()).getBody().get();
        payment.setOrderId(payment.getOrderId());
        return paymentRepository.save(payment);
    }

    @Override
    public void delete(Long id) {
         paymentRepository.deleteById(id);
    }

    @Override
    public Optional<Payment> findPaymentByid(Long id) {
        return paymentRepository.findById(id);
    }

    @Override
    public Optional<Payment> findByid(Long id) {
        return paymentRepository.findById(id);
    }

}
