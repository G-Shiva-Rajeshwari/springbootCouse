package com.gsrr.ExampleApplication.student;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StudentService {
	private final StudentRepository repository;
	 private final StudentMapper mapper;
	 public StudentService(StudentRepository repository, StudentMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	 }
	 
	 public StudentResponseDto saveStudent(@RequestBody StudentDto dto) {
		 var student = mapper.toStudent(dto);
			var savedStudent = 	repository.save(student);
			return mapper.toStudentResponseDto(savedStudent);
	 }
	 
		public StudentResponseDto findStudentById(@PathVariable("student-id") Integer id){
			 var student = repository.findById(id)
	                 .orElseThrow(() -> new RuntimeException("Student not found"));
			 return mapper.toStudentResponseDto(student);
		}
		
		public List<StudentResponseDto> findAllStudent(){
			return repository.findAll().stream().map(mapper::toStudentResponseDto).collect(Collectors.toList());
			//.stream().map(this::to);
		}
		
		public List<StudentResponseDto> findStudentByName(@PathVariable("student-name") String firstname){
			return repository.findAllByFirstnameContaining(firstname).stream().map(mapper::toStudentResponseDto).collect(Collectors.toList());
		}
		
		public void deleteStudentById(@PathVariable("student-id") Integer id){
			repository.deleteById(id);
		}
}
