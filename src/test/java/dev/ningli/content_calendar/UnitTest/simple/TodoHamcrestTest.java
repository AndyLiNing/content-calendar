package dev.ningli.content_calendar.UnitTest.simple;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// Matcher lib
public class TodoHamcrestTest {

    @Test
    void shouldCreateTodo() {

        Todo todo = new Todo(1, "Do some sports", true);
        assertThat(todo.description(), is("Do some sports"));
    }

}
