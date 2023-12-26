package com.gen.ai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gen.ai.dto.OrderDto;
import com.gen.ai.dto.OrderRequestDto;
import com.gen.ai.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{userId}/create-order")
    public ResponseEntity<String> createOrder(@PathVariable Long userId, @RequestBody OrderRequestDto orderRequestDto) {
        orderService.createOrder(userId, orderRequestDto);
        return ResponseEntity.ok("Order created successfully");
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long orderId) {
        OrderDto orderDto = orderService.getOrderById(orderId);
        return ResponseEntity.ok(orderDto);
    }

    @GetMapping("/{userId}/user-orders")
    public ResponseEntity<List<OrderDto>> getUserOrders(@PathVariable Long userId) {
        List<OrderDto> userOrders = orderService.getUserOrders(userId);
        return ResponseEntity.ok(userOrders);
    }

    // Additional endpoints as needed

}
