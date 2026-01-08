package com.gsrr.ExampleApplication.controller;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gsrr.ExampleApplication.dto.StudentDto;
import com.gsrr.ExampleApplication.dto.StudentResponseDto;
import com.gsrr.ExampleApplication.entity.School;
import com.gsrr.ExampleApplication.entity.Student;
import com.gsrr.ExampleApplication.mapper.StudentMapper;
import com.gsrr.ExampleApplication.repository.SchoolRepository;
import com.gsrr.ExampleApplication.repository.StudentRepository;
import com.gsrr.ExampleApplication.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {

private final StudentService studentService;

public StudentController(StudentService studentService) {
	this.studentService = studentService;
}

//	@PostMapping("/students")
//	public Student post(@RequestBody StudentDto student) {
//		return repository.save(student);
//	}
	
	@PostMapping("/students")
	public StudentResponseDto saveStudent(@Valid @RequestBody StudentDto studentdto) {
		return this.studentService.saveStudent(studentdto);
	}
	
	@GetMapping("/students/{student-id}")
	public StudentResponseDto findStudentById(@PathVariable("student-id") Integer id){
		return this.studentService.findStudentById(id);
	}
	
	@GetMapping("/students")
	public List<StudentResponseDto> findAllStudent(){
		return studentService.findAllStudent();
	}
	
	@GetMapping("/students/search/{student-name}")
	public List<StudentResponseDto> findStudentByName(@PathVariable("student-name") String firstname){
		return studentService.findStudentByName(firstname);
	}
	
	@DeleteMapping("/students/{student-id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteStudentById(@PathVariable("student-id") Integer id){
		studentService.deleteStudentById(id);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException exp
			){
		var errors = new HashMap<String, String>();
		exp.getBindingResult().getAllErrors().forEach(error -> {
			var fieldName = ((FieldError) error).getField();
			var errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
					
		});
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
	}
