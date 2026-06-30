package com.example.demo;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(BookService bookService) {
		return args -> {
			Book cleanCode = new Book();
			cleanCode.setTitle("Clean code");
			cleanCode.setAuthor("Robert Martin");
			cleanCode.setIsbn("9780132350884");
			cleanCode.setPrice(BigDecimal.valueOf(45.99));
			cleanCode.setDescription("A Handbook of Agile Software Craftsmanship");

			Book effectiveJava = new Book();
			effectiveJava.setTitle("Effective Java");
			effectiveJava.setAuthor("Joshua Bloch");
			effectiveJava.setIsbn("9780134685991");
			effectiveJava.setPrice(BigDecimal.valueOf(50.99));
			effectiveJava.setDescription("Best practices for Java programming");

			bookService.save(cleanCode);
			bookService.save(effectiveJava);

			System.out.println("All books: ");
			bookService.findAll().forEach(System.out::println);
		};
	}
}
