package com.hassan.auth.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    private final AuthenticationManager authenticationManager;

    /**
     * @param loginDto
     * @return UserDto
     */
    @PostMapping("/token")
    public String getToken(@Valid @RequestBody LoginDto loginDto) {
        log.info("get token user: {}", loginDto);
        final Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        if (authenticate.isAuthenticated()) {
            log.info("User authenticated: {}", loginDto);
            return authService.generateToken(loginDto.getEmail());
        }
        throw new RuntimeException("Invalid credentials");
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam String token) {
        log.info("Validating token: {}", token);
        authService.validateToken(token);
        return authService.getUserEmail(token);
    }

    /**
     * @param registerDto
     * @return UserDto
     */
    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterDto registerDto) {
        log.info("Registering user: {}", registerDto);
        return authService.register(registerDto);
    }

    @GetMapping("/user/${email}")
    public UserDto getUser(@RequestParam String email) {
        log.info("Getting user: {}", email);
        return authService.getUser(email);
    }


}
