package com.kruger.dashboardmicroservice.service;

import com.kruger.dashboardmicroservice.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    List<Company> getAll();

    Optional<Company> findById(Long id);

    Company save(Company associate);

}
