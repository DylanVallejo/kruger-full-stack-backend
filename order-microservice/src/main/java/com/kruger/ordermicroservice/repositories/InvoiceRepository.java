package com.kruger.ordermicroservice.repositories;


import com.kruger.ordermicroservice.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
