package org.example.demospring.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Harideep Reddy Boothpur
 * @created 3/27/26 4:27 PM
 */
@Entity
@Table(name = "customers")
@Data
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;


}
