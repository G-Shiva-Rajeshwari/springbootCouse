package com.gsrr.TaskManagement.project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProjectDetailsDto {

	 @NotBlank(message = "Name must not be null or empty")
	 @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
	private String name;
	 
	 @Size(min = 10, max = 50, message = "Name must be between 2 and 50 characters")
	private String description;

}
