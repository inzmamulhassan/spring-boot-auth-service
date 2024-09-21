package com.hassan.auth.service;

import com.hassan.auth.model.dto.RegisterDto;
import com.hassan.auth.model.dto.UserDto;

public interface AuthService {
    String register(RegisterDto registerDto);
    String generateToken(String email);
    void validateToken(String token);

    UserDto getUser(String email);

    String getUserEmail(String token);
}
