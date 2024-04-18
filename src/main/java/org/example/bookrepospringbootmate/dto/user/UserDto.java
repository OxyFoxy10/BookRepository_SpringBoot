package org.example.bookrepospringbootmate.dto.user;

import lombok.Data;
import org.example.bookrepospringbootmate.model.User;

@Data
public class UserDto {
    private Long id;
    private String email;
    private String name;
    private User.Role role;
}
