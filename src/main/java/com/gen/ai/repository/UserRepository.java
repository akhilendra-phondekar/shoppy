package com.gen.ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gen.ai.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
