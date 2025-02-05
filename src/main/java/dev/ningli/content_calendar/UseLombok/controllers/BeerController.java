package dev.ningli.content_calendar.UseLombok.controllers;

import dev.ningli.content_calendar.UseLombok.models.Beer;
import dev.ningli.content_calendar.UseLombok.services.BeerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/beer")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    List<Beer> getBeer() {

        return beerService.getBeer();
    }

}
