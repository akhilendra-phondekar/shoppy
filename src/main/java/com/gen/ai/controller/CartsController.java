package com.gen.ai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gen.ai.dto.CartDto;
import com.gen.ai.dto.CartItemDto;
import com.gen.ai.service.CartService;

@RestController
@RequestMapping("/api/carts")
public class CartsController {

    @Autowired
    private CartService cartService;

    @PostMapping("/{userId}/add-to-cart")
    public ResponseEntity<String> addToCart(@PathVariable Long userId, @RequestBody CartItemDto cartItemDto) {
        cartService.addToCart(userId, cartItemDto);
        return ResponseEntity.ok("Item added to cart successfully");
    }

    @GetMapping("/{userId}/view-cart")
    public ResponseEntity<CartDto> viewCart(@PathVariable Long userId) {
        CartDto cartDto = cartService.viewCart(userId);
        return ResponseEntity.ok(cartDto);
    }

    @PostMapping("/{userId}/checkout")
    public ResponseEntity<String> checkout(@PathVariable Long userId) {
        cartService.checkout(userId);
        return ResponseEntity.ok("Checkout successful");
    }

    // Additional endpoints as needed

}
