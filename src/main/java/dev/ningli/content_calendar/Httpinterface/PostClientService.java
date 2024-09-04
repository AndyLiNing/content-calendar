package dev.ningli.content_calendar.Httpinterface;

import org.springframework.web.bind.annotation.RequestParam;
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
}
