package com.hassan.auth.model.mapper;

import com.hassan.auth.model.dto.RegisterDto;
import com.hassan.auth.model.dto.UserDto;
import com.hassan.auth.model.entity.User;

public class UserMapper {
    private UserMapper() {
    }
    public static UserDto toUserDto(User user) {
        return UserDto.builder()
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .creationOn(user.getCreationOn().toString())
                .build();
    }

    public static User toUser(RegisterDto registerDto) {
        return User.builder()
                .email(registerDto.getEmail())
                .password(registerDto.getPassword())
                .firstName(registerDto.getFirstName())
                .lastName(registerDto.getLastName())
                .build();
    }
}
