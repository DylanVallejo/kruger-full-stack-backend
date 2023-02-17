package com.kruger.ordermicroservice.services;


import com.kruger.ordermicroservice.entities.Associate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AssociateService {
    List<Associate> getAll();

    Optional<Associate> findById(Long id);

    Associate save(Associate associate);

    void delete(Long id);
}
