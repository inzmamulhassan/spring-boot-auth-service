package com.hassan.auth.service;


public interface JWTService {
    public String generateToken(String email);
    public void validateToken(String token);
}
