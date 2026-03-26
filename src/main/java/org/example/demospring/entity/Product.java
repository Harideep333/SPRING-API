package org.example.demospring.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "coffee_name")
    private String coffeeName;

    private Double price;

    @Column(name = "coffee_origin")
    private String coffeeOrigin;

    @Column(name = "is_available")
    private Boolean isAvailable;
}