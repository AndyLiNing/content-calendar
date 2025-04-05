package dev.ningli.content_calendar.UnitTest.MVC;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@Service
public class PostService {

    private final RestClient restClient;


    public PostService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }


    public List<Post> getPosts() {
        return restClient
                .get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<>(){});
    }

    public ResponseEntity<Post> createPost(Post post) {

        return restClient
                .post()
                .uri("/posts")
                .body(post)
                .retrieve()
                .toEntity(Post.class);
    }

    public ResponseEntity<Post> updatePost(int id, Post post) {
        return restClient.put()
                .uri("/posts/" + id)
                .body(post)
                .retrieve()
                .toEntity(Post.class);
    }

}
