package com.ignaciocassi.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Object> registerCustomer(@RequestBody CustomerRegistrationRequest customerRequest) {
        log.info("New customer registration request {}", customerRequest);
        var response = customerService.registerCustomer(customerRequest);
        return CustomerResponseHandler.generateResponse(response.message(), response.status());
    }

    @GetMapping(path = "{email}")
    public ResponseEntity<Object> getCustomerByEmail(@PathVariable("email") String email) {
        log.info("Get customer by email request {}", email);
        Optional<Customer> customer = customerService.getByEmail(email);
        return customer.isPresent() ?
                CustomerResponseHandler.generateResponse(
                "The customer id for email " + email + " is " + customer.get().getId(),
                HttpStatus.OK,
                Optional.of(customer)) :
                CustomerResponseHandler.generateResponse(
                "No customer found with email " + email,
                HttpStatus.NOT_FOUND);
    }

}
