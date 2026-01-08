package com.gsrr.ExampleApplication.mapper;

import org.springframework.stereotype.Service;

import com.gsrr.ExampleApplication.dto.StudentDto;
import com.gsrr.ExampleApplication.dto.StudentResponseDto;
import com.gsrr.ExampleApplication.entity.School;
import com.gsrr.ExampleApplication.entity.Student;

@Service
public class StudentMapper {
	public Student toStudent(StudentDto dto) {
		var student = new Student();
		student.setFirstname(dto.firstname());
		student.setLastname(dto.lastname());
		student.setEmail(dto.email());
	
		var school = new School();
		school.setId(dto.schoolId());

		student.setSchool(school);
		return student;
	}
	
	public StudentResponseDto toStudentResponseDto(Student student) {
		return new StudentResponseDto(
				student.getFirstname(),
				student.getLastname(),
				student.getEmail()
				);
	}
}
