package com.gen.ai.dto;

import java.util.List;

public class OrderRequestDto {

    private List<CartItemDto> cartItems;

    // Constructors, getters, and setters

    public OrderRequestDto() {
        // Default constructor
    }

    public OrderRequestDto(List<CartItemDto> cartItems) {
        this.cartItems = cartItems;
    }

    // Getters and Setters

    public List<CartItemDto> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDto> cartItems) {
        this.cartItems = cartItems;
    }
}
