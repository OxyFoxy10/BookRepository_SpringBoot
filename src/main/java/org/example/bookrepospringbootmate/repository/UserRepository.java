package org.example.bookrepospringbootmate.repository;

import java.util.List;
import java.util.Optional;
import org.example.bookrepospringbootmate.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(attributePaths = "role")
    Optional<User> findByEmail(String email);

    List<User> findAllByRole(User.Role role);

    List<User> findAllByNameContainingIgnoreCase(String name);
}
