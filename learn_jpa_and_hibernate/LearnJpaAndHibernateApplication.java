package com.gsrr.springboot.learn_jpa_and_hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages =	"com.gsrr.springboot.learn_jpa_and_hibernate.course.springdatajpa")

//"com.gsrr.springboot.learn_jpa_and_hibernate.course.jpa"

public class LearnJpaAndHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnJpaAndHibernateApplication.class, args);
	}
//	jdbc:h2:mem:161b608a-f7f0-4c6d-8e59-80cad29e8e44
}
