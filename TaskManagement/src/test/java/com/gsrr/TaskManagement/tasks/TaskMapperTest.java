package com.gsrr.TaskManagement.tasks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gsrr.TaskManagement.tasks.Task.Priority;
import com.gsrr.TaskManagement.tasks.Task.Status;
import com.gsrr.TaskManagement.tasks.dto.TaskDetailsDto;
import com.gsrr.TaskManagement.tasks.dto.TaskMapper;

class TaskMapperTest {

	private TaskMapper mapper;
	
	@BeforeEach
	void setUp() {
		mapper = new TaskMapper();
	}
	@Test
	public void shouldMapDtoToTask() {
		TaskDetailsDto dto = new TaskDetailsDto(1,"title", "description", Status.TODO,
			    Priority.HIGH);
		Task task = mapper.toTask(dto);
		assertEquals(dto.getId(), task.getId());
		assertEquals(dto.getTitle(), task.getTitle());
		assertEquals(dto.getDescription(), task.getDescription());
		assertEquals(dto.getStatus(), task.getStatus());
		assertEquals(dto.getPriority(), dto.getPriority());
	}

}
