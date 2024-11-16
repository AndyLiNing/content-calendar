package dev.ningli.content_calendar.Https.GetRestTemplate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpClient;
import java.util.List;

@RestController()
public class GetTodoController {

    private final GetTodoService getTodoService;

    public GetTodoController(GetTodoService getTodoService){
        this.getTodoService = getTodoService;
    };
    HttpClient httpClient;
    @GetMapping(value = "/api/todos", produces = "application/json")
    List<Todo> findAll() {
        return getTodoService.findAll();
    }

}

