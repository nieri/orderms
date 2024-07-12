package tech.mnieri.rabbitmq.consumer.orderms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.mnieri.rabbitmq.consumer.orderms.controller.dto.OrderResponse;
import tech.mnieri.rabbitmq.consumer.orderms.controller.dto.ApiResponse;
import tech.mnieri.rabbitmq.consumer.orderms.service.OrderService;

@RestController
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("customers/{customerId}/orders")
    public ResponseEntity<ApiResponse<OrderResponse>> listOrders(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                                 @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize){

        return ResponseEntity.ok(null);
    }
}
