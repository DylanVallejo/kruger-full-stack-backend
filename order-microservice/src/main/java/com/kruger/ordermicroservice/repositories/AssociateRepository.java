package com.kruger.ordermicroservice.repositories;


import com.kruger.ordermicroservice.entities.Associate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociateRepository extends JpaRepository<Associate, Long> {
}
