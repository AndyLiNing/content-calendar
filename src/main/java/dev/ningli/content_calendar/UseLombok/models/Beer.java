package dev.ningli.content_calendar.UseLombok.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "beers")
@Getter
@Setter
@Data
@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    private int version;

    @Column(name = "beer_name")
    private String beerName;

    @Column(name = "beer_style")
    private BeerStyle beerStyle;

    private BigDecimal price;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
