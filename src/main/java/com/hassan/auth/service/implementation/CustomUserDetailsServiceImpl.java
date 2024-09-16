package com.hassan.auth.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hassan.auth.model.entity.User;
import com.hassan.auth.model.util.CustomUserDetails;
import com.hassan.auth.repository.AuthRepository;

import lombok.RequiredArgsConstructor;

public class CustomUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private  AuthRepository authRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = authRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user.getEmail(), user.getPassword());
    }
}
