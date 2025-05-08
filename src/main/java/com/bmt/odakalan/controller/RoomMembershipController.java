package com.bmt.odakalan.controller;

import com.bmt.odakalan.dto.user.UserDTO;
import com.bmt.odakalan.service.MembershipService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomMembershipController {

    private final MembershipService ms;

    @PostMapping("/{id}/join")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void join(@PathVariable Long id) { ms.join(id); }

    @PostMapping("/{id}/leave")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void leave(@PathVariable Long id) { ms.leave(id); }

    @GetMapping("/{id}/members")
    public List<UserDTO> members(@PathVariable Long id) { return ms.listMembers(id); }
}
