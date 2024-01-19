package com.ignaciocassi.fraud;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("api/v1/fraud-check")
public class FraudController {

    private final FraudCheckService fraudCheckService;


    @GetMapping(path = "{customerId}")
    public ResponseEntity<Boolean> isFraudster(@PathVariable("customerId") Integer customerId) {
        boolean isFraudulent = fraudCheckService.isFraudulentCustomer(customerId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
