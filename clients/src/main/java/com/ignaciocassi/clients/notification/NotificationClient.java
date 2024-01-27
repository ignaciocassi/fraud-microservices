package com.ignaciocassi.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("notification")
public interface NotificationClient {
    @PostMapping(path = "api/v1/notification")
    ResponseEntity<Object> send(@RequestBody NotificationRequest notificationRequest);
}
