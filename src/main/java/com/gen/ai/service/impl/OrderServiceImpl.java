package com.gen.ai.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gen.ai.dto.CartItemDto;
import com.gen.ai.dto.OrderDto;
import com.gen.ai.dto.OrderItemDto;
import com.gen.ai.dto.OrderRequestDto;
import com.gen.ai.dto.ProductDto;
import com.gen.ai.entity.Order;
import com.gen.ai.entity.OrderItem;
import com.gen.ai.repository.OrderItemRepository;
import com.gen.ai.service.CartService;
import com.gen.ai.service.OrderService;
import com.gen.ai.service.ProductService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductService productService;
    
    @Autowired
    private CartService cartService;

    @Override
    public void createOrder(Long userId, OrderRequestDto orderRequestDto) {
        // Retrieve user's cart items
        List<CartItemDto> cartItems = cartService.viewCart(userId).getCartItems();

        // Create Order and OrderItems
        Order order = new Order(userId, new ArrayList<>(), BigDecimal.ZERO, "PENDING");
        for (CartItemDto cartItem : cartItems) {
            ProductDto productDto = productService.getProductById(cartItem.getProductId());
            BigDecimal subtotal = BigDecimal.valueOf(productDto.getPrice()).multiply(BigDecimal.valueOf(cartItem.getQuantity()));

            OrderItem orderItem = new OrderItem(order, cartItem.getProductId(), cartItem.getQuantity(), subtotal);
            order.getOrderItems().add(orderItem);

            // Update product stock quantity
            productService.increaseStockQuantity(cartItem.getProductId(), cartItem.getQuantity());
        }

        // Calculate total order amount
        order.setTotalAmount(order.getOrderItems().stream().map(OrderItem::getSubtotal).reduce(BigDecimal.ZERO, BigDecimal::add));

        // Save the order to the database
        orderRepository.save(order);
    }

    @Override
    public OrderDto getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));

        List<OrderItem> orderItems = orderItemRepository.findByOrderId(order.getId());

        List<OrderItemDto> orderItemDtos = orderItems.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        return new OrderDto(order.getId(), order.getUserId(), orderItemDtos, order.getTotalAmount(), order.getOrderStatus());
    }

    @Override
    public List<OrderDto> getUserOrders(Long userId) {
        List<Order> userOrders = orderRepository.findByUserId(userId);

        return userOrders.stream()
                .map(order -> convertToDto(order))
                .collect(Collectors.toList());
    }

    // Additional methods as needed

    private OrderDto convertToDto(Order order) {
        List<OrderItem> orderItems = orderItemRepository.findByOrderId(order.getId());

        List<OrderItemDto> orderItemDtos = orderItems.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        return new OrderDto(order.getId(), order.getUserId(), orderItemDtos, order.getTotalAmount(), order.getOrderStatus());
    }

    private OrderItemDto convertToDto(OrderItem orderItem) {
        return new OrderItemDto(orderItem.getId(), orderItem.getProductId(),
                orderItem.getQuantity(), orderItem.getSubtotal());
    }

	@Override
	public void saveOrder(Order order) {
		orderRepository.save(order);
		
	}
}

