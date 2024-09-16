package com.hassan.auth.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginDto {
    @NotNull(message = "Email is required")
    private String email;
    @NotNull(message = "Password is required")
    private String password;
}
