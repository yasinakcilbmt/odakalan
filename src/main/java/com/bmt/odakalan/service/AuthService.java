package com.bmt.odakalan.service;

import com.bmt.odakalan.dto.auth.*;
import com.bmt.odakalan.dto.user.UserDTO;
import com.bmt.odakalan.mapper.UserMapper;
import com.bmt.odakalan.model.User;
import com.bmt.odakalan.repository.UserRepository;
import com.bmt.odakalan.security.CustomUserDetails;
import com.bmt.odakalan.security.JwtTokenUtil;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final UserMapper mapper;
    private final JwtTokenUtil jwt;
    private final UserService userService;

    public AuthResponse register(RegisterRequest request) {
        UserDTO dto = new UserDTO(
                null,
                request.email(),
                request.password(),
                request.displayName()
        );

        // 1. DTO'yu kaydet
        UserDTO savedDto = userService.create(dto);

        // 2. Gerçek entity'yi veritabanından çek (çünkü UserDetails entity ister)
        User savedEntity = repo.findById(savedDto.id()).orElseThrow();

        // 3. JWT üret
        String token = jwt.generateToken(new CustomUserDetails(savedEntity));

        // 4. Response dön
        return new AuthResponse(token, savedEntity.getId(), savedEntity.getDisplayName());
    }



    public AuthResponse login(LoginRequest req) {
        User user = repo.findByEmailAndDeletedAtIsNull(req.email())
                .orElseThrow(() -> new RuntimeException("Bad credentials"));
        if (!encoder.matches(req.password(), user.getPassword()))
            throw new RuntimeException("Bad credentials");
        return buildResponse(user);
    }

    private AuthResponse buildResponse(User u) {
        String token = jwt.generateToken(new CustomUserDetails(u));
        return new AuthResponse(token, u.getId(), u.getDisplayName());
    }
}
