package com.gsrr.ExampleApplication;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationConfig {
	   @Bean("myBean")
		//@Bean
		//@Qualifier("bean1")
	    public MyFirstClass myFirstBean() { 
		   return new MyFirstClass("first bean");
		   }
	
		@Bean
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
