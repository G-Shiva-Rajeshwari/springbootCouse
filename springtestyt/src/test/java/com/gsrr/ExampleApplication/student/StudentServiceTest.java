package com.gsrr.ExampleApplication.student;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)  
class StudentServiceTest {
	
	@InjectMocks
	private StudentService studentservice;
	
	@Mock
	private StudentRepository repository;
	
	@Mock
	private StudentMapper mapper;
	
//	@BeforeEach
//	void setUp() {
//		MockitoAnnotations.openMocks(this);
//	}
	@Test
	void testStudentService() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveStudent() {
		//Given
		StudentDto dto = new StudentDto("john","doe","john@email.com",3);
		Student student = new Student("john","doe","john@email.com",20);
		Student savedstudent = new Student("john","doe","john@email.com",20);
		
		savedstudent.setId(2);
		
		StudentResponseDto response = new StudentResponseDto("john","doe","john@email.com");
		//Mock the calls
		Mockito.when(mapper.toStudent(dto)).thenReturn(student);
		Mockito.when(repository.save(student)).thenReturn(savedstudent);
		Mockito.when(mapper.toStudentResponseDto(savedstudent)).thenReturn(response);
		
		//When
		StudentResponseDto responseDto = studentservice.saveStudent(dto);
		
		//Then
		assertEquals(dto.firstname(), responseDto.firstname());
		assertEquals(dto.lastname(), responseDto.lastname());
		assertEquals(dto.email(), responseDto.email());

		verify(mapper, times(1)).toStudent(dto);
		verify(repository, times(1)).save(student);
		verify(mapper, times(1)).toStudentResponseDto(savedstudent);

			}

	

	@Test
	void testFindStudentById() {
		Integer id = 25;
		Student student = new Student("john","doe","john@email.com",20);
		//StudentResponseDto response = new StudentResponseDto("john","doe","john@email.com");
		
		Mockito.when(repository.findById(id)).thenReturn(Optional.of(student));
		Mockito.when(mapper.toStudentResponseDto(any(Student.class))).thenReturn(new StudentResponseDto("john","doe","john@email.com"));
		
		StudentResponseDto dto = studentservice.findStudentById(id);
		
		assertEquals(dto.firstname(), student.getFirstname());
		assertEquals(dto.lastname(), student.getLastname());
		assertEquals(dto.email(), student.getEmail());
		verify(repository,times(1)).findById(id);
	}

	@Test
	void testFindAllStudent() {
		List<Student> student = new ArrayList<>(List.of(new Student("john","doe","john@email.com",20)));
	
		Mockito.when(repository.findAll()).thenReturn(student);
		Mockito.when(mapper.toStudentResponseDto(any(Student.class))).thenReturn(new StudentResponseDto("john","doe","john@email.com"));
		
		List<StudentResponseDto > response = studentservice.findAllStudent();
		
		assertEquals(student.size(), response.size());
		verify(repository,times(1)).findAll();
		
	}

	@Test
	void testFindStudentByName() {
		String name = "shiva";
		List<Student> students = new ArrayList<>(List.of(new Student("shiva","rajeshwari","john@email.com",20)));
		StudentResponseDto response = new StudentResponseDto("john","doe","john@email.com");
		
		Mockito.when(repository.findAllByFirstnameContaining(name)).thenReturn(students);
		Mockito.when(mapper.toStudentResponseDto(any(Student.class))).thenReturn(response);
		
		List<StudentResponseDto> responseDto = studentservice.findStudentByName(name);
		
		assertEquals(students.size(), responseDto.size());
		
		verify(repository,times(1)).findAllByFirstnameContaining(name);
		
//		 Mockito.when(mapper.toStudentResponseDto(any(Student.class)))
//         .thenAnswer(invocation -> {
//             Student s = invocation.getArgument(0);
//             return new StudentResponseDto(
//                 s.getFirstname(),
//                 s.getLastname(),
//                 s.getEmail()
//             );
//         });
//
//  List<StudentResponseDto> actualDtos = studentservice.findStudentByName(name);
//
//  assertEquals(expectedDtos.size(), actualDtos.size());
//
//  for (int i = 0; i < expectedDtos.size(); i++) {
//      assertEquals(expectedDtos.get(i).getFirstname(), actualDtos.get(i).getFirstname());
//      assertEquals(expectedDtos.get(i).getLastname(), actualDtos.get(i).getLastname());
//      assertEquals(expectedDtos.get(i).getEmail(), actualDtos.get(i).getEmail());
//  }
//
//  verify(repository, times(1)).findAllByFirstnameContaining(name);
//}
	}

	@Test
	void testDeleteStudentById() {
		fail("Not yet implemented");
	}

}
