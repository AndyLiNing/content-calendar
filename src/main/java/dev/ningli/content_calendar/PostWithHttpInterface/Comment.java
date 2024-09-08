package dev.ningli.content_calendar.PostWithHttpInterface;

public record Comment(Integer postId, Integer id, String name, String email, String body) {
}
