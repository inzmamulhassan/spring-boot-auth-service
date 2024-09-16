package com.hassan.auth.service.implementation;

import org.springframework.stereotype.Service;

import com.hassan.auth.model.dto.LoginDto;
import com.hassan.auth.model.dto.RegisterDto;
import com.hassan.auth.model.dto.UserDto;
import com.hassan.auth.model.mapper.UserMapper;
import com.hassan.auth.repository.AuthRepository;
import com.hassan.auth.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImp implements AuthService {
    private final AuthRepository authRepository;

    @Override
    public UserDto login(LoginDto loginDto) {
        return null;
    }

    @Override
    public UserDto register(RegisterDto registerDto) {
        return UserMapper.toUserDto((authRepository.save(UserMapper.toUser(registerDto))));
    }
}
