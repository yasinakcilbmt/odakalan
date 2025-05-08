package com.bmt.odakalan.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;



public record UserDTO(
        Long id,
        @Email String email,
        @NotBlank String password,
        @NotBlank String displayName
) {}
