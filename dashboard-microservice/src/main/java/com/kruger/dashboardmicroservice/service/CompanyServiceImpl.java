package com.kruger.dashboardmicroservice.service;

import com.kruger.dashboardmicroservice.entity.Company;
import com.kruger.dashboardmicroservice.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements  CompanyService{

    @Autowired
    CompanyRepository companyRepository;
    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }
}
