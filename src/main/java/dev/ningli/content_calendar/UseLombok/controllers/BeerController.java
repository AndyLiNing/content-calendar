package dev.ningli.content_calendar.UseLombok.controllers;

import dev.ningli.content_calendar.UseLombok.models.Beer;
import dev.ningli.content_calendar.UseLombok.services.BeerService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/beer")
public class BeerController {

    // private static final Logger log = org.slf4j.LoggerFactory.getLogger(BeerController.class);
    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    List<Beer> getBeer() {

        return beerService.getBeer();
    }

    @GetMapping(value = "/all")
    ResponseEntity getAllBeer() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/asdfa");
        return new ResponseEntity(headers, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public Beer getBeerById(@PathVariable("id") String beerId) {
        return Beer
                .builder()
                .build();
    }

    @PostMapping
    public Beer createBeer(@RequestBody Beer beer) {
        return beer;
    }

    @PutMapping(value = "{id}")
    public Beer updateBeer(@PathVariable("id") String beerId, @RequestBody Beer beer) {
        return beer;
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deleteBeer(@PathVariable("id") String beerId) {
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }
}
