package com.ignaciocassi.fraud;

import com.ignaciocassi.clients.customer.CustomerClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ignaciocassi.record.CustomerRecord;
import com.ignaciocassi.validator.CustomerUtils;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Map;
@Slf4j
@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    private final CustomerClient customerClient;

    public FraudCheckResponse isFraudulentCustomer(String email) {
        try {
            log.info("Checking if the customer request is fraudulent");
            ResponseEntity<Object> response = customerClient.findByEmail(email);
            CustomerRecord customer = CustomerUtils.extractCustomerFromResponse(response);
            saveFraudCheckHistory(customer.id());
            log.info("Fraud detected, a customer already was registered with this email {}", email);
            return new FraudCheckResponse(
                    HttpStatus.OK,
                    "Fraud detected, a customer already was registered with this email " + email,
                    true);
        } catch (FeignException.NotFound e) {
            log.info("No fraud detected, no customer was registered with this email {}", email);
            return new FraudCheckResponse(
                    HttpStatus.OK,
                    "No fraud detected, no customer was registered with this email " + email,
                    false);
        }
    }

    private void saveFraudCheckHistory(int id) {
        FraudCheckHistory fraudCheckHistory = FraudCheckHistory.builder()
                .createdAt(LocalDateTime.now())
                .isFraudster(true)
                .customerId(id)
                .build();
        fraudCheckHistoryRepository.save(fraudCheckHistory);
    }

}
