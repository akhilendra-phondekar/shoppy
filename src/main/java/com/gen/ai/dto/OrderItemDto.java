package com.gen.ai.dto;

import java.math.BigDecimal;

public class OrderItemDto {

    private Long orderItemId;
    private Long productId;
    private int quantity;
    private BigDecimal subtotal;

    // Constructors, getters, and setters

    public OrderItemDto() {
        // Default constructor
    }

    public OrderItemDto(Long orderItemId, Long productId, int quantity, BigDecimal subtotal) {
        this.orderItemId = orderItemId;
        this.productId = productId;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    // Getters and Setters

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}

