package com.gen.ai.service;

import com.gen.ai.dto.UserDto;

public interface UserService {

	void registerNewUser(UserDto userDto);

    void sendPasswordResetEmail(String email);

    void resetPassword(String resetToken, String newPassword);

}
