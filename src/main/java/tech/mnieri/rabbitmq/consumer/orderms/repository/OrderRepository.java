package tech.mnieri.rabbitmq.consumer.orderms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tech.mnieri.rabbitmq.consumer.orderms.entity.OrderEntity;

public interface OrderRepository extends MongoRepository<OrderEntity, Long> {
}
