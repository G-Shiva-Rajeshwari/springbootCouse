package com.gsrr.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gsrr.springboot.learn_jpa_and_hibernate.course.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner{

	@Autowired
	private CourseJdbcRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		//repository.insert();
		repository.insert(new Course(1,"learn microservices","shiva"));
		repository.insert(new Course(2,"learn Junit","sri"));
		repository.insert(new Course(3,"learn sql","shree"));
		repository.insert(new Course(4,"learn hibernate","sai"));
		repository.insert(new Course(5,"learn java","srija"));
		
		repository.deleteById(1);
		
		System.out.println(repository.findById(2));
		System.out.println(repository.findById(3));
	}

}
