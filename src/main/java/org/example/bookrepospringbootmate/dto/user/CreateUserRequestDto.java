package org.example.bookrepospringbootmate.dto.user;

import java.time.LocalDate;

public record CreateUserRequestDto(String email,
                                   String name,
                                   String password,
                                   String phone,
                                   LocalDate birthDate) {
}
