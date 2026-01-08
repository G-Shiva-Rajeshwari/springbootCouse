package com.gsrr.TaskManagement.user.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gsrr.TaskManagement.tasks.Task;
import com.gsrr.TaskManagement.user.User;

@Component
public class UserMapper {

	public User toUser(UserDetailsDto dto) {
		User user = new User();
    	user.setId(user.getId());
        user.setName(user.getName());
        user.setEmail(user.getEmail());

        return user; 

	}
	
	public UserResponseDto toDto(User user, List<Task> tasks) {
		UserResponseDto responseDto = new UserResponseDto();
		responseDto.setId(user.getId());
		responseDto.setName(user.getName());
		responseDto.setEmail(user.getEmail());
		responseDto.setTasks(user.getTasks());
		
		return responseDto;
	}
}
 