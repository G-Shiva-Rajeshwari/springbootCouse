package com.gsrr.ExampleApplication;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class ExampleApplication {

	public static void main(String[] args) {
		
		var app = new SpringApplication(ExampleApplication.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "dev"));
		var ctx = app.run(args);

			CustomProps cp = ctx.getBean(CustomProps.class);
			System.out.println(cp.getCustomProperty());

	}
	


}
