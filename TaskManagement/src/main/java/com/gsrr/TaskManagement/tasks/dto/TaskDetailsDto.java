package com.gsrr.TaskManagement.tasks.dto;

import com.gsrr.TaskManagement.tasks.Task.Priority;
import com.gsrr.TaskManagement.tasks.Task.Status;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TaskDetailsDto {
		@NotNull(message = "id must be not null")
	    private Integer id;
		@NotBlank(message = "title must not be null")
		@Size(min=5,max=50,message = "title must not be null or empty")
	    private String title;
		@Size(min=5,max=50,message = "must be atleast 5letters")
	    private String description;
		@NotBlank
	    private Status status;
		@NotBlank
	    private Priority priority;
	}
