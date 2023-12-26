package com.gen.ai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gen.ai.dto.LoginDto;
import com.gen.ai.dto.UserDto;
import com.gen.ai.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
        userService.registerNewUser(userDto);
        return ResponseEntity.ok("Registration successful");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDto loginDto) {
        // Perform login logic, e.g., authentication with username and password
        // You might use Spring Security for this purpose
        return ResponseEntity.ok("Login successful");
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestParam String email) {
        userService.sendPasswordResetEmail(email);
        return ResponseEntity.ok("Password reset email sent successfully");
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestParam String resetToken, @RequestParam String newPassword) {
        userService.resetPassword(resetToken, newPassword);
        return ResponseEntity.ok("Password reset successful");
    }

    // Additional endpoints for profile update, change password, etc.

}

