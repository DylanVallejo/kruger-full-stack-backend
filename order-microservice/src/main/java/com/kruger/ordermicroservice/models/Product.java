package com.kruger.ordermicroservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    //    @NotNull(message="Debes agregaar un nombre al producto")
    private String productName;
    private String description;
    private  String image;
    private Double price;
    private double height;
    private double width;
    private Long bestSelling;
    private  Boolean itsInOffers;
    private  Double discount;
    private Long stock;
    private Category category;


}
