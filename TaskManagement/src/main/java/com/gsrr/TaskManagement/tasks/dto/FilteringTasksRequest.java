package com.gsrr.TaskManagement.tasks.dto;

import com.gsrr.TaskManagement.tasks.Task;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilteringTasksRequest {
	private Task.Status status;
	private Task.Priority priority;
	private Integer userId;
	private Integer projectId;
}
