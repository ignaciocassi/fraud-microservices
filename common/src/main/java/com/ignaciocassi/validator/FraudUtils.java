package com.ignaciocassi.validator;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public class FraudUtils {
    public static boolean getIsFraudsterFromResponse(ResponseEntity<Object> response) {
        Map<String, Object> body = (Map<String, Object>) response.getBody();
        return Boolean.TRUE.equals(body.get("isFraudulent"));
    }
}
