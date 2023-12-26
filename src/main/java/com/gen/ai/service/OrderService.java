package com.gen.ai.service;

import java.util.List;

import com.gen.ai.dto.OrderDto;
import com.gen.ai.dto.OrderRequestDto;
import com.gen.ai.entity.Order;

public interface OrderService {

    void createOrder(Long userId, OrderRequestDto orderRequestDto);

    OrderDto getOrderById(Long orderId);

    List<OrderDto> getUserOrders(Long userId);

	void saveOrder(Order order);

    // Additional methods as needed

}

