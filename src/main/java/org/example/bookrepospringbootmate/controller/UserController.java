package org.example.bookrepospringbootmate.controller;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.bookrepospringbootmate.dto.user.CreateUserRequestDto;
import org.example.bookrepospringbootmate.dto.user.UserDto;
import org.example.bookrepospringbootmate.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id) {
        //http://localhost:8080/employees/1
        return userService.findById(id);
    }

    @GetMapping("/by-email")
    public Optional<UserDto> getByEmail(@RequestParam String email) {
        //http://localhost:8080/employees/by-email?email=john@gmail.com
        return userService.findByEmail(email);
    }

    @PostMapping
    public UserDto save(@RequestBody CreateUserRequestDto requestDto) {
        return userService.save(requestDto);
    }

    @PutMapping("/{id}")
    public UserDto update(@RequestBody CreateUserRequestDto requestDto, @PathVariable Long id) {
        return userService.update(requestDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
