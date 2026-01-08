package com.gsrr.ExampleApplication.student;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gsrr.ExampleApplication.student.Student;
import com.gsrr.ExampleApplication.student.StudentDto;
import com.gsrr.ExampleApplication.student.StudentMapper;
import com.gsrr.ExampleApplication.student.StudentResponseDto;

class StudentMapperTest {

	private StudentMapper mapper;
	
	@BeforeEach
	void setUp() {
		mapper = new StudentMapper();
	}
	
	@Test
	public void shouldMapStudentDtoToStudent() {
		StudentDto dto = new StudentDto("john","doe","john@email.com",3);
		Student student = mapper.toStudent(dto);
		Assertions.assertEquals(dto.firstname(), student.getFirstname());
		Assertions.assertEquals(dto.lastname(), student.getLastname());
		Assertions.assertEquals(dto.email(), student.getEmail());
		assertNotNull(student.getSchool());
		Assertions.assertEquals(dto.schoolId(), student.getSchool().getId());
	}
	
//	@Test
//	public void should_map_studentDto_to_student_when_studentDto_is_null() {
//		Student student = mapper.toStudent(null);
//		assertEquals("", student.getFirstname());
//		assertEquals("",student.getLastname());
//	}
	
	@Test
	public void should_throw_null_pointer_exception_when_studentDto_is_null() {
		// assertThrows(NullPointerException.class, ()->mapper.toStudent(null));
		var exp = assertThrows(NullPointerException.class, ()->mapper.toStudent(null));
		assertEquals("the student dto should not be null", exp.getMessage());
	}
	
	@Test
	public void shouldMapStudentToStudentResponseDto() {
		Student student = new Student(
				"Jane","smith","jane@email.com",20
				);
		StudentResponseDto response = mapper.toStudentResponseDto(student);
		assertEquals(response.firstname(), student.getFirstname());
		assertEquals(response.lastname(), student.getLastname());
		assertEquals(response.lastname(), student.getLastname());
		assertEquals(response.email(), student.getEmail());
	}
}
