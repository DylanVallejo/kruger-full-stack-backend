package com.kruger.ordermicroservice.controllers;

import com.kruger.ordermicroservice.entities.Associate;
import com.kruger.ordermicroservice.entities.OrderState;
import com.kruger.ordermicroservice.services.AssociateService;
import com.kruger.ordermicroservice.services.OrderStateService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Associate Controller", description = "Crud operations for Associate.")
@RestController
@RequestMapping("api/associate")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class AssociateController {

    @Autowired
    private AssociateService associateService;

    @GetMapping
    public List<Associate> getAll(){
        return associateService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Associate save(@RequestBody Associate state){
        return associateService.save(state);
    }


}
