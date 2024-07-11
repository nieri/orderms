package tech.mnieri.rabbitmq.consumer.orderms.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String ORDER_CREATED_QUEUE = "test-order-created";
}
