package dev.ningli.content_calendar.Https.GetHttpInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/security")
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

//    @GetMapping("/comments")
//    List<Comment> getCommentPost(@RequestParam(name = "postId") Integer id ) {
//        return postClientService.getCommentPost(id);
//    }

    @GetMapping("/comments")
    List<Comment> getCommentPostMap(@RequestParam Map<String, Integer> id) {
        return postClientService.getCommentPost(id);
    }

    @DeleteMapping("/comments/{id}")
    void deletePostById(@PathVariable int id){
        postClientService.deletePostById(id);
    }
}
