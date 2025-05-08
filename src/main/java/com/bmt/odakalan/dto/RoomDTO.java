package com.bmt.odakalan.dto;

import jakarta.validation.constraints.NotBlank;

public record RoomDTO(
        Long id,

        @NotBlank(message = "Oda ismi boş olamaz")
        String name,

        String description,

        Long creatorId
) {}
