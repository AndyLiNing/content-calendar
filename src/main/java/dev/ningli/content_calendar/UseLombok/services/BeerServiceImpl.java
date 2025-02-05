package dev.ningli.content_calendar.UseLombok.services;

import dev.ningli.content_calendar.UseLombok.models.Beer;
import dev.ningli.content_calendar.UseLombok.models.BeerStyle;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;


@Service
public class BeerServiceImpl implements BeerService {

    @Override
    public List<Beer> getBeer() {

        return List.of(
                Beer.builder()
                        .beerName("Tsing dao")
                        .beerStyle(BeerStyle.GOSE)
                        .uuid(UUID.randomUUID())
                        .price(BigDecimal.valueOf(15.20))
                        .createdAt(ZonedDateTime.now().toLocalDateTime())
                        .updatedAt(ZonedDateTime.now().toLocalDateTime())
                .build()
        );
    }
}
