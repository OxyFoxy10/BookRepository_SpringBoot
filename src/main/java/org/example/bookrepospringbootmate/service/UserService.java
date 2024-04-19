package org.example.bookrepospringbootmate.service;

import java.util.List;
import java.util.Optional;
import org.example.bookrepospringbootmate.dto.user.CreateUserRequestDto;
import org.example.bookrepospringbootmate.dto.user.UserDto;

public interface UserService {

    UserDto save(CreateUserRequestDto requestDto);

    UserDto findById(Long id);

    Optional<UserDto> findByEmail(String email);

    List<UserDto> findAll();

    UserDto update(CreateUserRequestDto requestDto);

    void delete(Long id);
}
