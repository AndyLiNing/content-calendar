package dev.ningli.content_calendar.UnitTestMVC;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UnitTestPostController {

    private final PostService postService;

    public UnitTestPostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/api/allPosts")
    public List<Post> getPosts() {

        return postService.getPosts();
    }

}
