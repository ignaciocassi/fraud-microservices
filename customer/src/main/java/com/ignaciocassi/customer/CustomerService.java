package com.ignaciocassi.customer;

import com.ignaciocassi.clients.fraud.FraudClient;
import com.ignaciocassi.clients.notification.NotificationClient;
import com.ignaciocassi.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final FraudClient fraudClient;

    private final NotificationClient notificationClient;


    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.saveAndFlush(customer);
        ResponseEntity<Object> response = fraudClient.isFraudster(customer.getId());
        if (response.getStatusCode().isError()) {
            throw new FraudException("Fraud detected for customer: " + customer.getId());
        }
        if (response.getStatusCode().is2xxSuccessful()) {
            NotificationRequest notificationRequest = NotificationRequest.builder()
                            .title("Fraud detected")
                            .toCustomerEmail(customer.getEmail())
                            .message("Fraud detected for customer: " + customer.getId())
                            .build();
            notificationClient.send(notificationRequest);
        }
        // TODO: check if email is not taken
        // TODO: check if email is valid
        // TODO: send notification
    }
}
