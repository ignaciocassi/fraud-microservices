package com.ignaciocassi.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(
        scanBasePackages = {
                "com.ignaciocassi.notification",
                "com.ignaciocassi.amqp"
        }
)
@EnableEurekaClient
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

    /*
    @Bean
    CommandLineRunner commandLineRunner(
            RabbitMQMessageProducer producer,
            NotificationConfig notificationConfig
    ) {
        return args -> {
            producer.publish(
                    notificationConfig.getInternalExchange(),
                    notificationConfig.getInternalNotificationRoutingKey(),
                    new Person("Ignacio", "Cassi", 26));
        };
    }

    public record Person(String name, String surname, int age) {
    }
    */
}
