package com.hassan.auth.service.implementation;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hassan.auth.model.dto.RegisterDto;
import com.hassan.auth.model.mapper.UserMapper;
import com.hassan.auth.repository.AuthRepository;
import com.hassan.auth.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImp implements AuthService {
    private final AuthRepository authRepository;
    private final JWTServiceImp jwtService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String register(RegisterDto registerDto) {
         registerDto.setPassword(passwordEncoder.encode(registerDto.getPassword()));
         authRepository.save(UserMapper.toUser(registerDto));
         return generateToken(registerDto.getEmail());
    }

    @Override
    public String generateToken(String email) {
        return jwtService.generateToken(email);
    }

    @Override
    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
}
