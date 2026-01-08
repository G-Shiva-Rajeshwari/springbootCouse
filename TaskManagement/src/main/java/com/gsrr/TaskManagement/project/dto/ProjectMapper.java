package com.gsrr.TaskManagement.project.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gsrr.TaskManagement.project.Project;
import com.gsrr.TaskManagement.tasks.Task;
import com.gsrr.TaskManagement.tasks.TaskRepository;

@Component
public class ProjectMapper {

public Project toProject(ProjectDetailsDto projectDto) {
	
	Project project = new Project();
	
	project.setName(projectDto.getName());
	project.setDescription(projectDto.getDescription());
	
	project.setTask(new ArrayList<>());
	return project;
}

public ProjectResponseDto toDto(Project project, List<Task> tasks) {
    ProjectResponseDto dto = new ProjectResponseDto();
    dto.setName(project.getName());
    dto.setTask(tasks);
    return dto;
}


}

