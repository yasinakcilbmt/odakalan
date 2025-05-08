package com.bmt.odakalan.service;

import com.bmt.odakalan.dto.RoomDTO;
import com.bmt.odakalan.error.NotFoundException;
import com.bmt.odakalan.mapper.RoomMapper;
import com.bmt.odakalan.model.Room;
import com.bmt.odakalan.model.User;
import com.bmt.odakalan.repository.RoomRepository;
import com.bmt.odakalan.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepo;
    private final UserRepository userRepo;
    private final RoomMapper mapper;

    // CREATE
    public RoomDTO create(RoomDTO dto) {
        // 1) creatorId ile gerçek User çekiliyor
        User creator = userRepo.findById(dto.creatorId())
                .orElseThrow(() -> new NotFoundException("Oda Bulunamadi"));

        // 2) DTO → Entity
        Room room = mapper.toEntity(dto);   // name, description, id…
        room.setCreator(creator);// Many‑to‑One ilişkiyi kurduk

        // 3) Kaydet
        Room saved = roomRepo.save(room);
        // INSERT rooms (...)
        // room.getId() şimdi dolu
        // 4) Entity → DTO geri dön
        return mapper.toDto(saved);
    }


    // READ ALL
    public List<RoomDTO> getAll() {
        return roomRepo.findAll().stream().map(mapper::toDto).toList();
    }

    // READ ONE
    public RoomDTO getById(Long id) {
        Room room = roomRepo.findById(id).orElseThrow(() -> new NotFoundException("Oda bulunamadı"));
        return mapper.toDto(room);
    }

    // UPDATE
    public RoomDTO update(Long id, RoomDTO dto) {
        Room room = roomRepo.findById(id).orElseThrow(() -> new RuntimeException("Oda bulunamadı"));
        mapper.updateEntityFromDto(dto, room);
        return mapper.toDto(room);
    }

    // DELETE
    public void delete(Long id) {
        roomRepo.deleteById(id);
    }
}
