package dev.ningli.content_calendar.UnitTestMVC;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

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

}
