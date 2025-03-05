package dev.ningli.content_calendar.UnitTest.MVC;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UnitTestPostController {

    private static Logger LOGGER = LoggerFactory.getLogger(UnitTestPostController.class);

    private final PostService postService;

    public UnitTestPostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/api/allPosts")
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @PostMapping("/api/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post body) {
        var post = postService.createPost(body);

        LOGGER.info(post.toString());
        return post;
    }

}
