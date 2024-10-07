package dev.ningli.content_calendar.JsonLoader.model;
public record Address(
        String street,
        String suite,
        String city,
        String zipcode,
        Geo geo
) {

}
