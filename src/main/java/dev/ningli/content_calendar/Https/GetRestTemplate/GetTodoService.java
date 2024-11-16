package dev.ningli.content_calendar.Https.GetRestTemplate;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTodoService {

    private final RestTemplate restTemplate;

    public GetTodoService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public List<Todo> findAll() {
        return restTemplate.exchange(
                "https://jsonplaceholder.typicode.com/todos",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Todo>>() {}
        ).getBody();
    }
}
