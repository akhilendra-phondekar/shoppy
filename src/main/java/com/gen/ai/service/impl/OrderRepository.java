package com.gen.ai.service.impl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gen.ai.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findByUserId(Long userId);

}
