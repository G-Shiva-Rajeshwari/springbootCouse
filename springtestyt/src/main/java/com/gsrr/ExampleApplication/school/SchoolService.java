package com.gsrr.ExampleApplication.school;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class SchoolService {
	private final SchoolRepository repository;
	private final SchoolMapper mapper;
	
	public SchoolService(SchoolRepository repository, SchoolMapper mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;
	}


	public SchoolDto create(SchoolDto schooldto) {
		var school = mapper.toSchool(schooldto);
		repository.save(school);
		return schooldto;
	}

	public List<SchoolDto> findAllSchools() {
		return repository.findAll().stream().map(mapper::toSchoolDto).collect(Collectors.toList());

	}
}
