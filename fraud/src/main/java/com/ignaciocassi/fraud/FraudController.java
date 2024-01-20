package com.ignaciocassi.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("api/v1/fraud-check")
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public ResponseEntity<Boolean> isFraudster(@PathVariable("customerId") Integer customerId) {
        log.info("Fraud check request for customer {}", customerId);
        boolean isFraudulent = fraudCheckService.isFraudulentCustomer(customerId);
        return new ResponseEntity<>(isFraudulent, HttpStatus.OK);
    }

}

