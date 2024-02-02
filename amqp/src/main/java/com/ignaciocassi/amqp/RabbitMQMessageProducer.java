package com.ignaciocassi.amqp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
@Slf4j
public class RabbitMQMessageProducer {

    private AmqpTemplate amqpTemplate;

    public void publish(String exchange, String routingKey, Object payload) {
        log.info("Publishing to exchange: {} using routingKey: {} payload: {}", exchange, routingKey, payload);
        amqpTemplate.convertAndSend(exchange, routingKey, payload);
        log.info("Published to exchange: {} using routingKey: {} payload: {}", exchange, routingKey, payload);
    }

}


