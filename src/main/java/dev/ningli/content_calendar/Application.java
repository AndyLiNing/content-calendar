package dev.ningli.content_calendar;

import dev.ningli.content_calendar.AutoConfigExample.PrintBanner;
import dev.ningli.content_calendar.JavaFoundations.ClassesLoader.Parent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private final List<Content> optionalContents = new ArrayList<>();

	public static void main(String[] args) throws ClassNotFoundException {
		System.setProperty("jdk.httpclient.HttpClient.log", "all");
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(Application.class, args);

		new Parent("parent");
		// ThreadFoundation.printThread();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("main implement CommandLineRunner");
		// Loader jl = new Loader();
		// jl.loadNonStaticData().forEach((System.out::println));
	}

	// Auto config
	@Bean
	CommandLineRunner runner (PrintBanner printBanner) {
		return args -> {
			System.out.println("Bean CommandLineRunner");
			printBanner.printer();
		};
	}

	// Print beans
	@Bean
	CommandLineRunner printBeans (ApplicationContext applicationContext) {
		return args -> {
			System.out.println("************************** BEANS START **************************");
			for (String beans : applicationContext.getBeanDefinitionNames()) {
				System.out.println(beans);
			}
			System.out.println("************************** BEANS END  **************************");
		};
	}

	private Optional<Content> findById(Integer id) {
		return optionalContents.stream().filter(v -> v.id().equals(1)).findFirst();
	}
}
