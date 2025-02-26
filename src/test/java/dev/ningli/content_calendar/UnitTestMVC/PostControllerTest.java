package dev.ningli.content_calendar.UnitTestMVC;


import dev.ningli.content_calendar.AutoConfigExample.PrintBanner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UnitTestPostController.class)
// @SpringBootTest
class UnitTestPostControllerTest {

    @MockitoBean
    PostService postService;

    @MockitoBean
    PrintBanner printBanner;

    @Autowired
    MockMvc mockMvc;

    @Test
    void should_get_all_posts() throws Exception {
        assertEquals(1 + 1 , 2);
        mockMvc.perform(
                get("/api/allPosts").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}