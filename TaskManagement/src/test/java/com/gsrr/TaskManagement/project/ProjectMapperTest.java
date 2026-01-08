package com.gsrr.TaskManagement.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.gsrr.TaskManagement.project.dto.ProjectDetailsDto;
import com.gsrr.TaskManagement.project.dto.ProjectMapper;
import com.gsrr.TaskManagement.project.dto.ProjectResponseDto;
import com.gsrr.TaskManagement.tasks.Task;

class ProjectMapperTest {

private ProjectMapper mapper;
	
	@BeforeEach
	void setUp() {
		mapper = new ProjectMapper();
	}
	
	@Test
	public void shouldMapProjectDtoToProject() {
		ProjectDetailsDto dto = new ProjectDetailsDto("Task Tracker", "A simple application to create, update, and track daily tasks");
		Project project = mapper.toProject(dto);
		assertEquals(dto.getName(),project.getName());
		assertEquals(dto.getDescription(),project.getDescription());
	}

    @Test
    void shouldInitializeTaskList() {
        Project project = mapper.toProject(
            new ProjectDetailsDto("Task Tracker", "Simple app")
        );

        assertNotNull(project.getTask());
    }

    @Test
    void shouldCreateEmptyTaskList() {
        Project project = mapper.toProject(
            new ProjectDetailsDto("Task Tracker", "Simple app")
        );

        assertTrue(project.getTask().isEmpty());
    }
    
    @Test
    void shouldMapProjectNameToDto() {
        Project project = new Project();
        project.setName("Task Tracker");

        ProjectResponseDto dto = mapper.toDto(project, new ArrayList<>());

        assertEquals("Task Tracker", dto.getName());
    }

    @Test
    void shouldMapTaskListToDto() {
        Project project = new Project();
        project.setName("Task Tracker");

        List<Task> tasks = new ArrayList<>();
        Task t1 = new Task();
        t1.setTitle("Task 1");
        Task t2 = new Task();
        t2.setTitle("Task 2");
        tasks.add(t1);
        tasks.add(t2);

        ProjectResponseDto dto = mapper.toDto(project, tasks);

        assertEquals(2, dto.getTask().size());
        assertEquals("Task 1", dto.getTask().get(0).getTitle());
        assertEquals("Task 2", dto.getTask().get(1).getTitle());
    }

    @Test
    void shouldHandleEmptyTaskList() {
        Project project = new Project();
        project.setName("Task Tracker");

        List<Task> emptyTasks = new ArrayList<>();

        ProjectResponseDto dto = mapper.toDto(project, emptyTasks);

        // The DTO task list exists and is empty
        assertNotNull(dto.getTask());
        assertTrue(dto.getTask().isEmpty());
    }
	
}