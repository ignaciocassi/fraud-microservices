package com.ignaciocassi.clients.fraud;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

public class FraudResponseHandler {

    public static ResponseEntity<Object> generateResponse(HttpStatus status, String message, boolean isFraudulent) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", status.toString());
        map.put("message", message);
        map.put("isFraudulent", isFraudulent);
        return new ResponseEntity<>(map, status);
    }

}