package dev.ningli.content_calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Application {
	private final List<Content> a = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	private Optional<Content> findById(Integer id) {
		return a.stream().filter(v -> v.id().equals(1)).findFirst();
	}

	private void test(){
		Content b = new Content(1, "test");
		System.out.println(b);
	}

}
