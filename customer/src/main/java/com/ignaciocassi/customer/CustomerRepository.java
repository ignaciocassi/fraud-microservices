package com.ignaciocassi.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    public Optional<Customer> findCustomerByEmail(String email);

}
