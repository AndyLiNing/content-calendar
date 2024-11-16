package dev.ningli.content_calendar.Https.GetHttpInterface;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;
import java.util.Map;

public interface PostClientService {

    @GetExchange("/posts")
    List<Post> getPosts();


    // comments?postId=1
//    @GetExchange("/comments")
//    List<Comment> getCommentPost(@RequestParam(name = "postId") Integer id);

    @GetExchange("/comments")
    List<Comment> getCommentPost(@RequestParam Map<String, Integer> id);

    @DeleteExchange("/posts/{id}")
    void deletePostById(@PathVariable int id);
}
