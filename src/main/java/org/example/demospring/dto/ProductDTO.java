package org.example.demospring.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String coffeeName;
    private Double price;
    private String coffeeOrigin;
    private Boolean isAvailable;
}