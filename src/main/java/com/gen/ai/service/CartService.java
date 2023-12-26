package com.gen.ai.service;

import com.gen.ai.dto.CartDto;
import com.gen.ai.dto.CartItemDto;

public interface CartService {

    void addToCart(Long userId, CartItemDto cartItemDto);

    CartDto viewCart(Long userId);

    void checkout(Long userId);

    // Additional methods as needed

}

