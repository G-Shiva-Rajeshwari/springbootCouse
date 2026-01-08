package com.gsrr.ExampleApplication.dto;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
		@NotEmpty(message = "firstname must not be empty")
		String firstname,
		@NotEmpty
		String lastname, 
		String email, 
		Integer schoolId) {

}
