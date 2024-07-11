package tech.mnieri.rabbitmq.consumer.orderms.service;

import org.springframework.stereotype.Service;
import tech.mnieri.rabbitmq.consumer.orderms.entity.OrderEntity;
import tech.mnieri.rabbitmq.consumer.orderms.entity.OrderItem;
import tech.mnieri.rabbitmq.consumer.orderms.listener.dto.OrderCreatedEvent;
import tech.mnieri.rabbitmq.consumer.orderms.repository.OrderRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {

    private OrderRepository  repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public void save(OrderCreatedEvent event) {

        var entity = new OrderEntity();
        entity.setOrderId(event.codigoPedido());
        entity.setCustomerId(event.codigoClient());
        entity.setItems(getOrderItems(event));
        entity.setTotal(getTotal(event));

        repository.save(entity);

    }

    private List<OrderItem> getOrderItems(OrderCreatedEvent event) {
        return event.itens().stream()
                .map(i -> new OrderItem(i.produto(), i.quantidade(), i.preco()))
                .toList();
    }

    private BigDecimal getTotal(OrderCreatedEvent event) {
        return event.itens()
                .stream()
                .map(i -> i.preco().multiply(BigDecimal.valueOf(i.quantidade())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ONE);
    }
}
