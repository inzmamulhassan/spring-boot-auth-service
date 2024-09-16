package com.hassan.auth.service;

import com.hassan.auth.model.dto.RegisterDto;

public interface AuthService {
    public String register(RegisterDto registerDto);
    public String generateToken(String email);
    public void validateToken(String token);
}
