package com.ignaciocassi.customer;

import org.springframework.http.HttpStatus;

public record CustomerRegisterResponse(
        HttpStatus status,
        String message) {
}
