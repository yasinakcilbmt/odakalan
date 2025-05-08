package com.bmt.odakalan.mapper;

import com.bmt.odakalan.dto.RoomDTO;
import com.bmt.odakalan.model.Room;
import org.mapstruct.*;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface RoomMapper {

    // DTO → Entity (creator alanını manuel set edeceğiz, ignore)
    @Mapping(target = "creator", ignore = true)
    @Mapping(target = "members", ignore = true) // çünkü DTO'da yok
    Room toEntity(RoomDTO dto);

    // Entity → DTO (creator.id → creatorId)
    @Mapping(source = "creator.id", target = "creatorId")
    RoomDTO toDto(Room entity);

    // DTO → Entity (update için)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "creator", ignore = true)
    @Mapping(target = "members", ignore = true)
    void updateEntityFromDto(RoomDTO dto, @MappingTarget Room entity);
}
