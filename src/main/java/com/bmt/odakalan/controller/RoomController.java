package com.bmt.odakalan.controller;

import com.bmt.odakalan.dto.RoomDTO;
import com.bmt.odakalan.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoomDTO create(@Valid @RequestBody RoomDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<RoomDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public RoomDTO getOne(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public RoomDTO update(@PathVariable Long id, @Valid @RequestBody RoomDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
