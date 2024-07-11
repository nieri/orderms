package tech.mnieri.rabbitmq.consumer.orderms.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import tech.mnieri.rabbitmq.consumer.orderms.listener.dto.OrderCreatedEvent;

import static tech.mnieri.rabbitmq.consumer.orderms.config.RabbitMQConfig.ORDER_CREATED_QUEUE;

@Component
public class OrderCreatedListener {

    private final Logger logger = LoggerFactory.getLogger(OrderCreatedListener.class);

    @RabbitListener(queues = ORDER_CREATED_QUEUE)
    public void listen(Message<OrderCreatedEvent> message) {

        logger.info("Message consumed: {}", message);
    }
}
