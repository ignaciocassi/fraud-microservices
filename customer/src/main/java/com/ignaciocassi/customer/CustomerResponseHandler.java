package com.ignaciocassi.customer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CustomerResponseHandler {

    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Optional<Object> responseObj) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("status", status.toString());
        responseObj.ifPresent(data -> map.put("data", data));
        return new ResponseEntity<>(map, status);
    }

}