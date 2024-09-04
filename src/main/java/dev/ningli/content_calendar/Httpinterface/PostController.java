package dev.ningli.content_calendar.Httpinterface;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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

//    @GetMapping("/comments")
//    List<Comment> getCommentPost(@RequestParam(name = "postId") Integer id ) {
//        return postClientService.getCommentPost(id);
//    }

    @GetMapping("/comments")
    List<Comment> getCommentPostMap(@RequestParam Map<String, Integer> id) {
        return postClientService.getCommentPost(id);
    }
}
