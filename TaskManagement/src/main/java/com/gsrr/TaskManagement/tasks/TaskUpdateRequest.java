package com.gsrr.TaskManagement.tasks;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskUpdateRequest {
	private Task.Status status;
	private Task.Priority priority;
}
