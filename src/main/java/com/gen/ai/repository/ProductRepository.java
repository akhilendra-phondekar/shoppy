package com.gen.ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gen.ai.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
