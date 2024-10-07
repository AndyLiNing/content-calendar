package dev.ningli.content_calendar;

import dev.ningli.content_calendar.AutoConfigExample.PrintBanner;
import dev.ningli.content_calendar.JsonLoader.Loader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private final List<Content> a = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Loader jl = new Loader();
		// jl.loadNonStaticData().forEach((System.out::println));
	}

	@Bean
	CommandLineRunner runner ( PrintBanner printBanner ) {
		return args -> {
			System.out.println("Bean CommandLineRunner");
			printBanner.printer();
		};
	}

	private Optional<Content> findById(Integer id) {
		return a.stream().filter(v -> v.id().equals(1)).findFirst();
	}





}
