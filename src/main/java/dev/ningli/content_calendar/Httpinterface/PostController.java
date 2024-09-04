package dev.ningli.content_calendar.Httpinterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    private final PostClientService postClientService;

    @Autowired
    public PostController(PostClientService postClientService){
        this.postClientService = postClientService;
    }

    @GetMapping("/posts")
    List<Post> getPosts() {
        return postClientService.getPosts();
    }

    @GetMapping("/comments")
    List<Comment> getCommentPost(@RequestParam(name = "postId") Integer id ) {
        return postClientService.getCommentPost(id);
    }

}
