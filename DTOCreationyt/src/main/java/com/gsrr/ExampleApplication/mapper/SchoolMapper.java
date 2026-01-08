package com.gsrr.ExampleApplication.mapper;

import org.springframework.stereotype.Service;

import com.gsrr.ExampleApplication.dto.SchoolDto;
import com.gsrr.ExampleApplication.entity.School;

@Service
public class SchoolMapper {
	public School toSchool(SchoolDto dto) {
		 
		return new School(dto.name());
	}

	public SchoolDto toSchoolDto(School school) {
		return new SchoolDto(school.getName());
	}
}
