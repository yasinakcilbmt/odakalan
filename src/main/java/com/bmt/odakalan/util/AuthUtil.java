package com.bmt.odakalan.util;

import com.bmt.odakalan.security.CustomUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthUtil {
    public Long currentUserId() {
        var principal = SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return ((CustomUserDetails) principal).getId();
    }
}
