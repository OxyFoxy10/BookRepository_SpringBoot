package org.example.bookrepospringbootmate.service;


import lombok.RequiredArgsConstructor;
import org.example.bookrepospringbootmate.dto.user.CreateUserRequestDto;
import org.example.bookrepospringbootmate.dto.user.UserDto;
import org.example.bookrepospringbootmate.exception.EntityNotFoundException;
import org.example.bookrepospringbootmate.mapper.UserMapper;
import org.example.bookrepospringbootmate.model.User;
import org.example.bookrepospringbootmate.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{


    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public UserDto save(CreateUserRequestDto requestDto) {
        assert userMapper != null;
        User user = userMapper.toEntity(requestDto);

        assert userRepository != null;
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    @Override
    public UserDto findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(()-> new EntityNotFoundException("User not found by id: " + id));
    }

    @Override
    public Optional<UserDto> findByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email)
                .map(userMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("User not found by email: " + email)));
    }


    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .toList();
    }

    @Override
    public UserDto update(CreateUserRequestDto requestDto) {
//        userRepository.findById(user.getId()).orElseThrow(() ->
//                new EntityNotFoundException("Not found user with id " + user.getId()
//                        + " for update"));
//        return userRepository.save(user);

        assert userMapper != null;
        User user = userMapper.toEntity(requestDto);
        assert userRepository != null;
        userRepository.findById(user.getId()).orElseThrow(() ->
                new EntityNotFoundException("Not found book with id " + user.getId()
                        + " for update"));
        User updatedUser = userRepository.save(user);

        return userMapper.toDto(updatedUser);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
