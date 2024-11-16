package dev.ningli.content_calendar.Https.GetRestTemplate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GetTodoServiceTest {
    @Autowired
    private GetTodoService getTodoService;

    @Test
    void testFindAll() {
       List<Todo> todos = getTodoService.findAll();
       assertEquals(200, todos.size());
    }
}