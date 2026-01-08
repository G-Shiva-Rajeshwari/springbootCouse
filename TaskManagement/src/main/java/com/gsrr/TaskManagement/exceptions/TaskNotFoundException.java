package com.gsrr.TaskManagement.exceptions;

public class TaskNotFoundException extends RuntimeException {
	public TaskNotFoundException(String msg) {
		super(msg);
	}
}
