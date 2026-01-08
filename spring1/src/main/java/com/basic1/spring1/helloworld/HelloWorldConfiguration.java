package com.basic1.spring1.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address) {
};// eliminates the verbosity of creating beans.

record Address(String firstLine, String city) {
};

@Configuration
public class HelloWorldConfiguration {
//this class contains all the spring beans
//spring beans means that are to be controlled/managed by spring itself.
//to write those springbeans we declare class with @Configuration

	@Bean // says that a method goning to return a val that need to manage by spring
			// container
	public String name() {
		return "shiva";
	}

	@Bean
	public int age() {
		return 15;
	}

	@Bean(name = "address2")
	@Primary
	public Address address() {
		return new Address("23-708", "Hyderabad");
	}

	@Bean
	@Qualifier("add3qualifier")
	public Address address3() {
		return new Address("side street", "chennai");
	}

	@Bean
	public Person person() {
		return new Person("Ravi", 20, new Address("main street", "chennai"));
	}

	@Bean
	// methodcall
	public Person person2() {
		return new Person(name(), age(), address());// using the existing vals
	}

	@Bean
	// by parameters
	public Person person3(String name, int age, Address address3) {
		return new Person(name, age, address3);// using the existing vals
	}

	@Bean
	public Person person4(String name, int age, @Qualifier("add3qualifier") Address address) {
		return new Person(name, age, address);// using the existing vals
	}

}
