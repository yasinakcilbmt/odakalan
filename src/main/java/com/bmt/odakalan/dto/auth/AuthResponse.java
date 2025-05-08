package com.bmt.odakalan.dto.auth;

public record AuthResponse(
        String token,
        Long userId,
        String displayName
) {}
