package org.example.demospring.service;

import org.example.demospring.entity.Customers;
import org.example.demospring.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Harideep Reddy Boothpur
 * @created 3/27/26 4:29 PM
 */
@Service
public class CustomerService {

    @Autowired
    private final CustomersRepository customersRepository;

//    @Autowired
//    private CustomerService customerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CustomerService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public Customers register(Customers customer){
        String encryptedPassword = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(encryptedPassword);
        return customersRepository.save(customer);
    }


    public boolean login(String username, String password) {
        return false;
    }
}
