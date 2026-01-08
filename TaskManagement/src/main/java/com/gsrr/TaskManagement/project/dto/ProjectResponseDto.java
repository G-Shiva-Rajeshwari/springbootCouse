package com.gsrr.TaskManagement.project.dto;

import java.util.List;

import com.gsrr.TaskManagement.tasks.Task;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectResponseDto {
	
	private String name;
	private List<Task> task;
}
