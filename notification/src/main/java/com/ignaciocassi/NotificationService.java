package com.ignaciocassi;

import com.ignaciocassi.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private NotificationRepository notificationRepository;

    public boolean send(NotificationRequest request) {
        Notification notification = Notification.builder()
                .message(request.message())
                .sender("ignaciocassi")
                .sentAt(LocalDateTime.now())
                .toCustomerEmail(request.toCustomerEmail())
                .toCustomerId(1)
                .title(request.title())
                .build();
        // TODO: Get the customer id by email from customer service
        notificationRepository.saveAndFlush(notification);
        return true;
    }

}
