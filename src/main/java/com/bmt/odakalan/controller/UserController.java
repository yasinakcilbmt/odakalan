package com.bmt.odakalan.controller;

import com.bmt.odakalan.dto.user.UserDTO;
import com.bmt.odakalan.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public List<UserDTO> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public UserDTO getOne(@PathVariable Long id) { return service.getById(id); }

    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
