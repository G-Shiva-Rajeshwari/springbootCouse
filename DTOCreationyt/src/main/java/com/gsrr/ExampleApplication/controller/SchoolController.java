package com.gsrr.ExampleApplication.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gsrr.ExampleApplication.dto.SchoolDto;
import com.gsrr.ExampleApplication.entity.School;
import com.gsrr.ExampleApplication.entity.Student;
import com.gsrr.ExampleApplication.mapper.SchoolMapper;
import com.gsrr.ExampleApplication.repository.SchoolRepository;
import com.gsrr.ExampleApplication.service.SchoolService;

@RestController
public class SchoolController {
	private final SchoolService schoolService;

	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}

	@PostMapping("/schools")
	public SchoolDto create(@RequestBody SchoolDto schooldto) {
		return schoolService.create(schooldto);
	}
	
	@GetMapping("/schools")
	public List<SchoolDto> findAllSchools(){
		return schoolService.findAllSchools();
	}
}
