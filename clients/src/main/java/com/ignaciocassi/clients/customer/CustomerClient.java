package com.ignaciocassi.clients.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("customer")
public interface CustomerClient {

    @GetMapping(path = "api/v1/customers/{email}")
    ResponseEntity<Object> findByEmail(@PathVariable("email") String email);

}
