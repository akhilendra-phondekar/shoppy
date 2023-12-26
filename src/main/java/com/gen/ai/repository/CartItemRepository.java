package com.gen.ai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gen.ai.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
	List<CartItem>  findByCartId(Long cartId);
	void deleteByCartId(Long cartId);
}
