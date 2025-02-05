package dev.ningli.content_calendar.InterfaceController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface UserInterface {

    @GetMapping(value = "/api/interface-users")
    List<User> getAllUsers();

    @GetMapping(value = "/api/interface-users/{id}")
    Optional<User> getUserById(@PathVariable int id);
}
