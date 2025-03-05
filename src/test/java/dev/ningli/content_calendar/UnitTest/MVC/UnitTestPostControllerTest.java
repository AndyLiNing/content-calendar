package dev.ningli.content_calendar.UnitTest.MVC;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.ningli.content_calendar.AutoConfigExample.PrintBanner;
import dev.ningli.content_calendar.Security.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import javax.sql.DataSource;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UnitTestPostController.class)
// @Import annotation brings in the Beans in the bean configuration class
@Import(SecurityConfig.class)
// @SpringBootTest
class UnitTestPostControllerTest {

    @MockitoBean
    private DataSource dataSource;

    @MockitoBean
    PostService postService;

    @MockitoBean
    PrintBanner printBanner;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Captor
    ArgumentCaptor<Post> createPostCaptor;

    @Test
    void should_get_all_posts() throws Exception {
        // GIVEN
        var posts = List.of(new Post(1, 1, "", "What is 1"),
                new Post(2, 2, "", "What is"),
                new Post(3, 3, "", "What is"),
                new Post(4, 4, "", "What is"));

        // WHEN
        when(postService.getPosts()).thenReturn(posts);

        // THEN
        mockMvc.perform(
                get("/api/allPosts")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].body", is("What is 1")))
                .andExpect(jsonPath("$.length()", is(4)));

        verify(postService, times(1)).getPosts();
    }

    @Test
    void should_create_post() throws Exception {
        // GIVEN
        var postRequestDTO = new Post(12, null, "first Post", "first Post Body");
        var postResponseDTO = new Post(12, 1, "first Post", "first Post Body");

        // WHEN
        when(postService.createPost(createPostCaptor.capture()))
                .thenReturn(ResponseEntity.ok(postResponseDTO));

        // THEN
        mockMvc.perform(post("/api/posts")
                        .content(objectMapper.writeValueAsString(postRequestDTO))
                        .contentType(MediaType.APPLICATION_JSON)
                        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId", is(12)))
                .andExpect(jsonPath("$.title", is("first Post")));

        verify(postService, times(1)).createPost(any(Post.class));

        assertEquals(createPostCaptor.getValue().body(), postRequestDTO.body());
        assertEquals(createPostCaptor.getValue().title(), postRequestDTO.title());
        assertEquals(createPostCaptor.getValue(), postRequestDTO);

    }

    // Test Role (admin/user) based endpoint

    // Test Method-Level Security

}

