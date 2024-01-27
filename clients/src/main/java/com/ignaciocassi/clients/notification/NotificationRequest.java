package com.ignaciocassi.clients.notification;

import lombok.Builder;

@Builder
public record NotificationRequest(String title, String message, String toCustomerEmail) {
}
