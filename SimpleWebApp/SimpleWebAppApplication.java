package com.gsrr.SimpleWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SimpleWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleWebAppApplication.class, args);
	}

}
