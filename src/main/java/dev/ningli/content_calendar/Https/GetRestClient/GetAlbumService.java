package dev.ningli.content_calendar.Https.GetRestClient;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class GetAlbumService {

    private final RestClient restClient;

    public GetAlbumService(RestClient.Builder restClientBuilder) {
        restClient = restClientBuilder.baseUrl("https://jsonplaceholder.typicode.com").build();
    }

    public List<Album> findAll() {
        return restClient
                .get()
                .uri("/albums")
                .retrieve()
                .body(new ParameterizedTypeReference<>(){});
    }

}
