package com.gen.ai.dto;

import java.math.BigDecimal;
import java.util.List;

public class OrderDto {

    private Long orderId;
    private Long userId;
    private List<OrderItemDto> orderItems;
    private BigDecimal totalAmount;
    private String orderStatus;

    // Constructors, getters, and setters

    public OrderDto() {
        // Default constructor
    }

    public OrderDto(Long orderId, Long userId, List<OrderItemDto> orderItems, BigDecimal totalAmount, String orderStatus) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderItems = orderItems;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
    }

    // Getters and Setters

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<OrderItemDto> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDto> orderItems) {
        this.orderItems = orderItems;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}

