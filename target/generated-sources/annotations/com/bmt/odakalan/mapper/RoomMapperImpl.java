package com.bmt.odakalan.mapper;

import com.bmt.odakalan.dto.RoomDTO;
import com.bmt.odakalan.model.Room;
import com.bmt.odakalan.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-11T22:28:14+0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class RoomMapperImpl implements RoomMapper {

    @Override
    public Room toEntity(RoomDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Room room = new Room();

        room.setId( dto.id() );
        room.setName( dto.name() );
        room.setDescription( dto.description() );

        return room;
    }

    @Override
    public RoomDTO toDto(Room entity) {
        if ( entity == null ) {
            return null;
        }

        Long creatorId = null;
        Long id = null;
        String name = null;
        String description = null;

        creatorId = entityCreatorId( entity );
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();

        RoomDTO roomDTO = new RoomDTO( id, name, description, creatorId );

        return roomDTO;
    }

    @Override
    public void updateEntityFromDto(RoomDTO dto, Room entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.id() != null ) {
            entity.setId( dto.id() );
        }
        if ( dto.name() != null ) {
            entity.setName( dto.name() );
        }
        if ( dto.description() != null ) {
            entity.setDescription( dto.description() );
        }
    }

    private Long entityCreatorId(Room room) {
        if ( room == null ) {
            return null;
        }
        User creator = room.getCreator();
        if ( creator == null ) {
            return null;
        }
        Long id = creator.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
