package com.gen.ai.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gen.ai.dto.UserDto;
import com.gen.ai.entity.User;
import com.gen.ai.exception.UserNotFoundException;
import com.gen.ai.repository.UserRepository;
import com.gen.ai.service.EmailService;
import com.gen.ai.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private EmailService emailService;

    @Override
    public void registerNewUser(UserDto userDto) {
        // Implement user registration logic, including validation, password hashing, etc.
        // You may use a mapper to convert UserDto to User entity
        User user = new User(userDto.getUsername(), userDto.getEmail(), userDto.getPassword());
        userRepository.save(user);
        // Additional logic, such as sending a verification email, can be added here
    }

    @Override
    public void sendPasswordResetEmail(String email) {
        // Implement logic to generate and send a password reset email
        // You may use a service like JavaMailSender for this purpose
        // Set a reset token in the user entity for verification in the resetPassword method
    	User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UserNotFoundException("User not found with email: " + email);
        }

        // Generate a unique token for password reset (you may use a library for this)
        String resetToken = generateResetToken();

        // Save the token to the user entity
        user.setResetToken(resetToken);
        userRepository.save(user);
        
     // Send a password reset email with the reset link
        emailService.sendEmail(user.getEmail(), "Password Reset", "Click the link below to reset your password: " +
                "\n\nhttp://your-app-url/reset-password?token=" + resetToken);
    }

    

	@Override
    public void resetPassword(String resetToken, String newPassword) {
        // Implement logic to reset the user's password using the reset token
        // Update the user entity with the new password
    }

    // Additional methods for profile update, change password, etc.
	
	private String generateResetToken() { 
		return "unique_token_generated_here";
	}
}
