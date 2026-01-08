package com.gsrr.ExampleApplication;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gsrr.ExampleApplication.repository.SchoolRepository;

@RestController
public class SchoolController {

	private final SchoolRepository repository;
	
	public SchoolController(SchoolRepository repository) {
		super();
		this.repository = repository;
	}

	@PostMapping("/schools")
	public School create(@RequestBody School school) {
		return repository.save(school);
	}
	
	@GetMapping("/schools")
	public List<School> findAll(){
		return repository.findAll();
	}
}
