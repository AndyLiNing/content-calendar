package dev.ningli.content_calendar.Https.GetRestClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAlbumController {

    private final GetAlbumService getAlbumService;
    public GetAlbumController(GetAlbumService getAlbumService) {
        this.getAlbumService = getAlbumService;
    }

    @GetMapping(value = "/api/albums")
    public List<Album> findAll() {
        return getAlbumService.findAll();
    }
}
