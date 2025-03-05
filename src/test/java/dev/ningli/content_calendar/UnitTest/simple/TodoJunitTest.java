package dev.ningli.content_calendar.UnitTest.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// Test runner and assert lib
public class TodoJunitTest {

    @Test
    void shouldCreateTodo() {

        Todo todo = new Todo(1, "cleaning", false);

        Assertions.assertEquals("cleaning", todo.description());
        Assertions.assertFalse(todo.complete());
    }
}
