package com.bmt.odakalan.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterRequest(
        @Email(message = "Geçerli bir email giriniz") String email,
        @NotBlank(message = "Şifre boş olamaz") String password,
        @NotBlank(message = "İsim boş olamaz") String displayName
) {}
