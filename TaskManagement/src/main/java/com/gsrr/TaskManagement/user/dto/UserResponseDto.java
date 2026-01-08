package com.gsrr.TaskManagement.user.dto;

import java.util.List;

import com.gsrr.TaskManagement.tasks.Task;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
	
	private Integer id;
	private String name;
	private String email;
	private List<Task> tasks;
}
