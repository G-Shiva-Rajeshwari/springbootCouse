package com.gsrr.ExampleApplication;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class ApplicationConfig {
//	   @Bean("myBean")
	   
		@Bean
		@Qualifier("bean1")
//		@Profile("dev")
	    public MyFirstClass myFirstBean() { 
		   return new MyFirstClass("first bean");
		   }
	
		@Bean
//		@Profile("test")
		//@Qualifier("bean2")
		 public MyFirstClass mySecBean() { 
			   return new MyFirstClass("sec bean");
			   }
		
		@Bean
		//@Primary
		 public MyFirstClass myThirdBean() { 
			   return new MyFirstClass("Third bean");
			   }
	}
