package com.gen.ai.dto;

import java.util.List;

public class CartDto {

    private Long cartId;
    private Long userId;
    private List<CartItemDto> cartItems;

    // Constructors, getters, and setters

    public CartDto() {
        // Default constructor
    }

    public CartDto(Long cartId, Long userId, List<CartItemDto> cartItems) {
        this.cartId = cartId;
        this.userId = userId;
        this.cartItems = cartItems;
    }

    // Getters and Setters

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<CartItemDto> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDto> cartItems) {
        this.cartItems = cartItems;
    }
}
