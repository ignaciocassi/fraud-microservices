package com.ignaciocassi.notification;

import com.ignaciocassi.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("api/v1/notification")
@AllArgsConstructor
public class NotificationController {

    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Object> send(@RequestBody NotificationRequest notificationRequest) {
        log.info("Send notification request received for customer email: {} title: {} message {}",
                notificationRequest.toCustomerEmail(),
                notificationRequest.title(),
                notificationRequest.message());
        boolean created = notificationService.send(notificationRequest);
        // TODO: Handle responses
        return created ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

}
