package com.bmt.odakalan.service;

import com.bmt.odakalan.dto.user.UserDTO;
import com.bmt.odakalan.mapper.UserMapper;
import com.bmt.odakalan.model.User;
import com.bmt.odakalan.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repo;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    // --- CREATE ---
    public UserDTO create(UserDTO dto) {
        User user = mapper.toEntity(dto);

        user.setPassword(passwordEncoder.encode(dto.password()));
        user.setEmail(dto.email());
        user.setDisplayName(dto.displayName());

        User saved = repo.save(user);
        return mapper.toDto(saved);
    }

    // --- READ ALL ---
    public List<UserDTO> getAll() {
        return repo.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    // --- READ ONE ---
    public UserDTO getById(Long id) {
        return mapper.toDto(
                repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"))
        );
    }
    public User getUserById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // --- DELETE (Soft) ---
    public void delete(Long id) {
        repo.findById(id).ifPresent(User::softDelete);
    }
}
