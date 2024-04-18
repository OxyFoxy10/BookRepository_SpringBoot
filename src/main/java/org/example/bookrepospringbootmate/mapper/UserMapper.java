package org.example.bookrepospringbootmate.mapper;

import org.example.bookrepospringbootmate.config.MapperConfig;
import org.example.bookrepospringbootmate.dto.user.CreateUserRequestDto;
import org.example.bookrepospringbootmate.dto.user.UserDto;
import org.example.bookrepospringbootmate.model.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(CreateUserRequestDto requestDto);
}
