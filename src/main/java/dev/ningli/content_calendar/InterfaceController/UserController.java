package dev.ningli.content_calendar.InterfaceController;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController implements UserInterface {

    @Override
    public List<User> getAllUsers() {
        return List.of(new User(1, "test1"), new User(2, "test2"));
    }

    @Override
    public Optional<User> getUserById(int id) {
        return List.of(new User(1, "test1"), new User(2, "test2")).stream().filter(user -> user.id() == id).findFirst();
    }
}
