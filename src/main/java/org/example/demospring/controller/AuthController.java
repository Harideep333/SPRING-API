package org.example.demospring.controller;

import org.example.demospring.entity.Customers;
import org.example.demospring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Harideep Reddy Boothpur
 *  3/27/26 4:39 PM
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private final CustomerService customerService;

    public AuthController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public Customers register(@RequestBody Customers customers){
        return customerService.register(customers);
    }

    @PostMapping("/login")
    public String login(@RequestBody Customers customers){
        boolean isValid = customerService.login(customers.getUsername(), customers.getPassword());
        return isValid ? "Login Successful" : "Invalid Credentials";
    }


}
