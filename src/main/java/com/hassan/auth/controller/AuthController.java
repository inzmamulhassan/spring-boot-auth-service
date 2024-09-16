package com.hassan.auth.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hassan.auth.model.dto.LoginDto;
import com.hassan.auth.model.dto.RegisterDto;
import com.hassan.auth.model.dto.UserDto;
import com.hassan.auth.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    /**
     * @param loginDto
     * @return UserDto
     */
    @PostMapping("/login")
    public UserDto login(@Valid @RequestBody LoginDto loginDto) {
        log.info("Logging in user: {}", loginDto);
        return authService.login(loginDto);
    }

    /**
     * @param registerDto
     * @return UserDto
     */
    @PostMapping("/register")
    public UserDto register(@Valid @RequestBody RegisterDto registerDto) {
        log.info("Registering user: {}", registerDto);
        return authService.register(registerDto);
    }
}
