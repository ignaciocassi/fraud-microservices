package com.ignaciocassi.fraud;

import org.springframework.http.HttpStatus;

public record FraudCheckResponse(HttpStatus status, String message, Boolean isFraudulent) {
}
