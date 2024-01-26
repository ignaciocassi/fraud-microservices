package com.ignaciocassi.customer;

import com.ignaciocassi.clients.fraud.FraudClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final FraudClient fraudClient;


    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.saveAndFlush(customer);
        ResponseEntity<Object> response = fraudClient.isFraudster(customer.getId());
        if (response.getStatusCode().is2xxSuccessful()) {
            throw new FraudException("Fraud detected for customer: " + customer.getId());
        }
        // TODO: check if email is valid
        // TODO: check if email is not taken
        // TODO: send notification
    }
}
