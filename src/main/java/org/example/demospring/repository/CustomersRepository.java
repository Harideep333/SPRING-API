package org.example.demospring.repository;

import org.example.demospring.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Harideep Reddy Boothpur
 * @created 3/27/26 5:07 PM
 */

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {




}