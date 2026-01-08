package com.gsrr;

import java.util.Collections;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.domain.Specification;

import com.github.javafaker.Faker;
import com.gsrr.lombok.Author;
import com.gsrr.lombok.Video;
import com.gsrr.lombok.specification.AuthorSpecification;
import com.gsrr.repository.AuthorRepository;
import com.gsrr.repository.ViedoRepository;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
	    SpringApplication.run(ExampleApplication.class,args);
	}
	   @Bean
	    public CommandLineRunner commandLineRunner(AuthorRepository repository, ViedoRepository viedoRepository) {
	        return args -> {
	        	for(int i=0;i<50;i++) {
	        		Faker faker = new Faker();
	            var author = Author.builder()
	                               .firstname(faker.name().firstName())
	                               .lastname(faker.name().lastName())
	                               .age(faker.number().numberBetween(19, 50))
	                               .email("contact"+i+"@gmail.com")
	                               .build();
	         //   repository.save(author);
	        	}
	        	
	        	var author = Author.builder()
	        			.id(1)
                        .firstname("shiva")
                        .lastname("rajeshwari")
                        .age(20)
                        .email("gsrrcontact@gmail.com")
                        .build();
	        	//repository.save(author);
	        	
	        	//repository.updateAuthor(22, 1);
	        	//repository.updateAllAuthor(20);
	        	
	        	//var authors = 
	        	//repository.findByNamedQuery(40).forEach(System.out::println);
	        	
	        	//repository.updateByNamedQuery(18);
//	            var video = Video.builder().name("abc").length(5).build();
//	            viedoRepository.save(video);
	        	
	        	Specification<Author> spec = Specification
	        			.where(AuthorSpecification.hasAge(42))
	        			.and(AuthorSpecification.firstnameLike("Ce"));
	        	repository.findAll(spec).forEach(System.out::println);
	        	
	        	Specification<Author> spec1 = Specification
	        			.where(AuthorSpecification.hasAge(42))
	        			.or(AuthorSpecification.firstnameLike("Ce"));
	        	repository.findAll(spec1).forEach(System.out::println);
	        };
	    }
	}
