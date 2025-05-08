package com.bmt.odakalan.mapper;

import com.bmt.odakalan.dto.auth.RegisterRequest;
import com.bmt.odakalan.dto.user.UserDTO;
import com.bmt.odakalan.model.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {

    //
    User toEntity(RegisterRequest dto);

    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "displayName", target = "displayName")
    User toEntity(UserDTO dto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "displayName", target = "displayName")
    UserDTO toDto(User entity);

    // Update için DTO → Entity
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(UserDTO dto, @MappingTarget User entity);
}
