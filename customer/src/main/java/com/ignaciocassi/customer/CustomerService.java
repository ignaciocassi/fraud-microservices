package com.ignaciocassi.customer;

import com.ignaciocassi.amqp.RabbitMQMessageProducer;
import com.ignaciocassi.clients.fraud.FraudClient;
import com.ignaciocassi.clients.notification.NotificationRequest;
import com.ignaciocassi.validator.EmailValidator;
import com.ignaciocassi.validator.FraudUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final FraudClient fraudClient;

    private final RabbitMQMessageProducer rabbitMQMessageProducer;


    public CustomerRegistrationResponse registerCustomer(CustomerRegistrationRequest request) {
        // Create customer entity from request
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // Check if the email is valid
        if (!EmailValidator.isValid(request.email())) {
            return new CustomerRegistrationResponse(
                    HttpStatus.BAD_REQUEST,
                    "The email provided is not valid.");
        }
        // Check if the request is fraudulent, another customer exists with the given email address
        ResponseEntity<Object> response = fraudClient.isFraudster(request.email());
        if (response.getStatusCode().is2xxSuccessful()) {
            boolean isFraudster = FraudUtils.getIsFraudsterFromResponse(response);
            if (isFraudster) {
                NotificationRequest notificationRequest = NotificationRequest.builder()
                        .title("Fraud detected")
                        .toCustomerEmail(customer.getEmail())
                        .message("Fraud attempt detected on your email " + customer.getEmail())
                        .build();
                rabbitMQMessageProducer.publish("internal.exchange",
                        "internal.notification.routing-key",
                        notificationRequest
                );
            } else {
                // No fraud was detected, save the new customer
                customerRepository.saveAndFlush(customer);
            }
        }
        return new CustomerRegistrationResponse(
                HttpStatus.CREATED,
                "Customer registered");
    }

    public Optional<Customer> getByEmail(String email) {
        Optional<Customer> customer = customerRepository.findCustomerByEmail(email);
        return customer;
    }

}
