package com.ignaciocassi.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer(Integer customerId) {
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .createdAt(LocalDateTime.now())
                        .isFraudster(false)
                        .customerId(customerId)
                        .build()
        );
        // TODO: Remove hardcoded value
        return true;
    }

}
