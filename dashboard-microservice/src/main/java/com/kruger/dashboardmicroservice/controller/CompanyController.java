package com.kruger.dashboardmicroservice.controller;

import com.kruger.dashboardmicroservice.entity.Company;
import com.kruger.dashboardmicroservice.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<Company> getAll(){
        return companyService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company save(@RequestBody Company order){
        return companyService.save(order);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Company>> getById(@PathVariable("id") Long id){
        Optional<Company> order = companyService.findById(id);
        if(order==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(order);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Company> update(@RequestBody Company company,@PathVariable("id") Long id ){

        Company company1= companyService.findById(id).get();
        company1.setName(company1.getName());
        company1.setAddress(company.getAddress());
        company1.setCity(company.getCity());
        company1.setPhone(company.getPhone());
        company1.setCell_phone(company.getCell_phone());
        company1.setEmail(company.getEmail());
        company1.setMission(company.getMission());
        company1.setVision(company.getVision());
        Company companytNew = companyService.save(company1);
        return ResponseEntity.ok(companytNew);
    }

}
