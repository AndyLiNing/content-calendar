package dev.ningli.content_calendar.JsonLoader;

import dev.ningli.content_calendar.JsonLoader.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class LoadUserController {

    @GetMapping()
    public List<User> getUsers() throws IOException {

        return new Loader().loadNonStaticData();

    }
}
