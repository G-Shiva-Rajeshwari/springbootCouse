package com.gsrr.springboot.learnspringboot.courses.controller;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gsrr.springboot.learnspringboot.courses.bean.controller.Course;


@RestController
public class CourseController {
@GetMapping("/courses")
public List<Course> getAllCourses(){
	return Arrays.asList(new Course(1,"Learn Microservices","shiva"),
			new Course(2,"Learn Angular","gsrr"));
}

@GetMapping("/courses/1")
public Course getCourse(){
	return new Course(1,"Learn Microservice","shiva");
}
}
