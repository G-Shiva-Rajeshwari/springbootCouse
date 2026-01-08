package com.gsrr.ExampleApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsrr.ExampleApplication.entity.Student;

import java.util.List;

public interface StudentRepository  extends JpaRepository<Student, Integer>{
	List<Student> findAllByFirstnameContaining(String firstname);
}
