package com.hassan.auth.service;

import com.hassan.auth.model.dto.LoginDto;
import com.hassan.auth.model.dto.RegisterDto;
import com.hassan.auth.model.dto.UserDto;

public interface AuthService {
    public UserDto login(LoginDto loginDto);
    public UserDto register(RegisterDto registerDto);
}
