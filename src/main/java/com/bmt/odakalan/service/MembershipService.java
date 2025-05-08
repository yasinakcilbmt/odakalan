package com.bmt.odakalan.service;

import com.bmt.odakalan.error.BadRequestException;
import com.bmt.odakalan.error.NotFoundException;
import com.bmt.odakalan.model.Room;
import com.bmt.odakalan.model.User;
import com.bmt.odakalan.repository.RoomRepository;
import com.bmt.odakalan.repository.UserRepository;
import com.bmt.odakalan.dto.user.UserDTO;
import com.bmt.odakalan.util.AuthUtil;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class MembershipService {

    private final RoomRepository roomRepo;
    private final UserRepository userRepo;
    private final AuthUtil auth;

    public void join(Long roomId) {
        Room room = roomRepo.findById(roomId)
                .orElseThrow(() -> new NotFoundException("Oda bulunamadı"));
        User user = userRepo.findById(auth.currentUserId()).orElseThrow();

        if (!room.getMembers().add(user))
            throw new BadRequestException("Zaten üyesiniz");
    }

    public void leave(Long roomId) {
        Room room = roomRepo.findById(roomId)
                .orElseThrow(() -> new NotFoundException("Oda bulunamadı"));
        User user = userRepo.findById(auth.currentUserId()).orElseThrow();

        if (!room.getMembers().remove(user))
            throw new BadRequestException("Üye değilsiniz");
    }

    public List<UserDTO> listMembers(Long roomId) {
        Room room = roomRepo.findById(roomId)
                .orElseThrow(() -> new NotFoundException("Oda bulunamadı"));
        return room.getMembers().stream()
                .map(u -> new UserDTO(u.getId(), u.getEmail(), null, u.getDisplayName()))
                .toList();
    }
}
