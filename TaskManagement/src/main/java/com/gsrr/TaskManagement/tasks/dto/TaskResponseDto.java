package com.gsrr.TaskManagement.tasks.dto;

import com.gsrr.TaskManagement.tasks.Task;
import com.gsrr.TaskManagement.tasks.Task.Status;

public record TaskResponseDto(
		Integer id, String title, String description, Task.Status status, Task.Priority priority
			){

}
