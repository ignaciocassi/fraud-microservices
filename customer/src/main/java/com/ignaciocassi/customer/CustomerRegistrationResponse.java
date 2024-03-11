package com.ignaciocassi.customer;

import org.springframework.http.HttpStatus;

public record CustomerRegistrationResponse(
        HttpStatus status,
        String message) {
}
