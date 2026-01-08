package com.gsrr.JPA;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.gsrr.Author;
import com.gsrr.JPA.repositories.AuthorRepository;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepository repository
			) {
		 return args -> {
			 var author = Author.builder().firstname("abc").lastname("def").age(20).email("abc@gmail.com").build();
//	            // Create Author object without Lombok
//	            Author author = new Author("Shiva", "Rajeshwari", "gsrr@email.com",20);
//	            
//	            // Save to database
//	            repository.save(author);
//
//	            System.out.println("Author saved: " + author.getFirstname() + " " + author.getLastname());
	            
	            
	        };
	}
}
