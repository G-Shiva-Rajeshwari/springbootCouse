package com.gsrr.ExampleApplication;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gsrr.ExampleApplication.repository.StudentRepository;
import java.util.List;

@RestController
public class FirstController {

	private final StudentRepository repository;

	public FirstController(StudentRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping("/students")
	public void post(@RequestBody Student student) {
		repository.save(student);
	}
	
	@GetMapping("/students/{student-id}")
	public Student findStudentById(@PathVariable("student-id") Integer id){
		return repository.findById(id).orElse(null);
	}
	
	@GetMapping("/students")
	public List<Student> findAllStudent(){
		return repository.findAll();
	}
	
	@GetMapping("/students/search/{student-name}")
	public List<Student> findStudentByName(@PathVariable("student-name") String firstname){
		return repository.findAllByFirstnameContaining(firstname);
	}
	
	@DeleteMapping("/students/{student-id}")
	public void deleteStudentById(@PathVariable("student-id") Integer id){
		repository.deleteById(id);
	}
}
