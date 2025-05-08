package com.bmt.odakalan.mapper;

import com.bmt.odakalan.dto.auth.RegisterRequest;
import com.bmt.odakalan.dto.user.UserDTO;
import com.bmt.odakalan.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-08T15:05:44+0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(RegisterRequest dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( dto.email() );
        user.setPassword( dto.password() );
        user.setDisplayName( dto.displayName() );

        return user;
    }

    @Override
    public User toEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( dto.email() );
        user.setPassword( dto.password() );
        user.setDisplayName( dto.displayName() );
        user.setId( dto.id() );

        return user;
    }

    @Override
    public UserDTO toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String email = null;
        String password = null;
        String displayName = null;

        id = entity.getId();
        email = entity.getEmail();
        password = entity.getPassword();
        displayName = entity.getDisplayName();

        UserDTO userDTO = new UserDTO( id, email, password, displayName );

        return userDTO;
    }

    @Override
    public void updateEntityFromDto(UserDTO dto, User entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.id() != null ) {
            entity.setId( dto.id() );
        }
        if ( dto.email() != null ) {
            entity.setEmail( dto.email() );
        }
        if ( dto.password() != null ) {
            entity.setPassword( dto.password() );
        }
        if ( dto.displayName() != null ) {
            entity.setDisplayName( dto.displayName() );
        }
    }
}
