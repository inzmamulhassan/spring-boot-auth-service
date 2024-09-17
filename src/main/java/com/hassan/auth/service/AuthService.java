package com.hassan.auth.service;

import com.hassan.auth.model.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);
    String generateToken(String email);
    void validateToken(String token);
}
