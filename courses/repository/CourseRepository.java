package com.gsrr.springboot.learnspringboot.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsrr.springboot.learnspringboot.courses.bean.controller.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
