package com.gsrr.TaskManagement.user;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gsrr.TaskManagement.tasks.Task;
import com.gsrr.TaskManagement.user.dto.UserDetailsDto;
import com.gsrr.TaskManagement.user.dto.UserMapper;
import com.gsrr.TaskManagement.user.dto.UserResponseDto;

class UserMapperTest {

	private UserMapper mapper;
	
	@BeforeEach
	void setUp() {
		mapper = new UserMapper();
	}
	
	@Test
	void shouldMapUserDtoToUser() {
		UserDetailsDto dto = new UserDetailsDto(1,"shiva","shiva@gmail.com");
		User user = mapper.toUser(dto);
		assertEquals(dto.getId(), user.getId());
		assertEquals(dto.getName(), user.getName());
		assertEquals(dto.getEmail(), user.getEmail());	
	}
	
	@Test
	void shouldMapUserToResponseDto() {
		User user = new User();
		user.setId(1);
		user.setName("shiva");
		user.setEmail("shiva@gmail.com");
	
		List<Task> tasks = new ArrayList<>();
		 Task t1 = new Task();
	        t1.setTitle("Task 1");
	        Task t2 = new Task();
	        t2.setTitle("Task 2");
	        tasks.add(t1);
	        tasks.add(t2);

	        UserResponseDto dto = mapper.toDto(user, tasks);

	        assertEquals(2, dto.getTasks().size());
	        assertEquals("Task 1", dto.getTasks().get(0).getTitle());
	        assertEquals("Task 2", dto.getTasks().get(1).getTitle());
		
	}
	

}
