package com.gsrr.TaskManagement.tasks.dto;

import org.springframework.stereotype.Component;

import com.gsrr.TaskManagement.tasks.Task;

@Component
public class TaskMapper {

	public Task toTask(TaskDetailsDto dto) {
		Task task = new Task();
		task.setId(dto.getId());
		task.setTitle(dto.getTitle());
		task.setDescription(dto.getDescription());
		task.setStatus(dto.getStatus());
		task.setPriority(dto.getPriority());
		
		return task;
	}
}
