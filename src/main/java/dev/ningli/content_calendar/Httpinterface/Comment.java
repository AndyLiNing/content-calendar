package dev.ningli.content_calendar.Httpinterface;

public record Comment(Integer postId, Integer id, String name, String email, String body) {
}
