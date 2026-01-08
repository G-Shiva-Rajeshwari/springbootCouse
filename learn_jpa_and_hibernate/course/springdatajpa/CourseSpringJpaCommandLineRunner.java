package com.gsrr.springboot.learn_jpa_and_hibernate.course.springdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
 

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gsrr.springboot.learn_jpa_and_hibernate.course.Course;



@Component
public class CourseSpringJpaCommandLineRunner implements CommandLineRunner{

//	@Autowired
//	private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;
	@Override
	public void run(String... args) throws Exception {
		//repository.insert();
		repository.save(new Course(1,"learn microservices","shiva"));
		repository.save(new Course(2,"learn Junit","sri"));
		repository.save(new Course(3,"learn sql","ajay jpa"));
		repository.save(new Course(4,"learn hibernate","sai"));
		repository.save(new Course(5,"learn java","srija"));
		
		repository.deleteById(1l);
		
		System.out.println(repository.findById(2l));
		System.out.println(repository.findById(3l));
		
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		System.out.println(repository.findByAuthor("sai"));
		System.out.println(repository.findByAuthor(""));

	}

}
