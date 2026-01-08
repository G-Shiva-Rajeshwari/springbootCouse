package com.basic1.spring1.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		// launch a spring context &&

		var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);// used to launch spring
																							// context

		// configure the things that we want spring to manage
		// HelloWorldConfiguration -- @Configuration
		// name - @Bean

		// 3. Retrieving Beans managed by Spring
		System.out.println(context.getBean("name"));

		System.out.println(context.getBean("age"));

		System.out.println("person---------------------");
		System.out.println(context.getBean("person"));

		System.out.println("person2 by method call---------------------");
		System.out.println(context.getBean("person2"));

		System.out.println("person3 by parameters---------------------");
		System.out.println(context.getBean("person3"));

		System.out.println("person4 using qualifier---------------------");
		System.out.println(context.getBean("person4"));
		// System.out.println(context.getBean("address"));

		System.out.println("address2---------------------");
		System.out.println(context.getBean("address2"));

		System.out.println("address3---------------------");
		System.out.println(context.getBean("address3"));

		// lists all the beans managed by spring framework
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

		System.out.println("Adderess by primary---------------");
		System.out.println(context.getBean(Address.class));

	}

}
