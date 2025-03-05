package dev.ningli.content_calendar.UnitTest.simple;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

// Assert lib
public class TodoAssertJTest {
    @Test
    void shouldCreateNewTodo() {
        var test = new Todo(2,"Cooking", true);

        assertThat(test.description())
                .startsWith("C")
                .endsWith("ing")
                .containsIgnoringCase("OO")
                .isEqualToIgnoringCase("Cooking");
    }
}
