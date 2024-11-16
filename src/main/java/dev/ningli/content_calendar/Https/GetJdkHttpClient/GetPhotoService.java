package dev.ningli.content_calendar.Https.GetJdkHttpClient;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class GetPhotoService {

    private final HttpClient httpClient;
    private final static String BASE_URL = "https://jsonplaceholder.typicode.com";
    public GetPhotoService() {
        httpClient = HttpClient.newHttpClient();
    }

    public String findAll() throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(BASE_URL + "/photos"))
                                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
    }
}
