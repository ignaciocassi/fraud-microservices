package com.ignaciocassi.fraud;

import com.ignaciocassi.clients.fraud.FraudResponseHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("api/v1/fraud-check")
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public ResponseEntity<Object> isFraudster(@PathVariable("customerId") Integer customerId) {
        log.info("Fraud check request for customer {}", customerId);
        boolean isFraudulent = fraudCheckService.isFraudulentCustomer(customerId);
        return FraudResponseHandler.generateResponse(
                HttpStatus.OK,
                isFraudulent ?
                        "Fraud detected for customerId: " + customerId :
                        "No fraud detected for customerId: " + customerId,
                isFraudulent);
    }

}

