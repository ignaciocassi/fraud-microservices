package com.ignaciocassi.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(EmailNotFoundException.class)
    public ResponseEntity<Object> handleEmailNotFound(EmailNotFoundException exception) {
        log.error("Handling EmailNotFoundException: " + exception.getMessage());
        Map<String, String> body = new HashMap<>();
        body.put("message", exception.getMessage());
        body.put("status", HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

}
