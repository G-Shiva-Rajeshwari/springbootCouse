package com.gsrr.TaskManagement.project;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsrr.TaskManagement.project.dto.ProjectMapper;
import com.gsrr.TaskManagement.exceptions.IdNotFoundException;
import com.gsrr.TaskManagement.project.dto.ProjectDetailsDto;
import com.gsrr.TaskManagement.project.dto.ProjectResponseDto;
import com.gsrr.TaskManagement.project.dto.ProjectUpdateRequest;
import com.gsrr.TaskManagement.tasks.Task;
import com.gsrr.TaskManagement.tasks.TaskRepository;

@Service
public class ProjectService {

	private ProjectRepository projectRepository;
	
	//private Project project;
	
	private TaskRepository taskRepository;
	
	private ProjectMapper projectMapper;
	
	public ProjectService(ProjectRepository projectRepository, TaskRepository taskRepository, ProjectMapper projectMapper) {
		super();
		this.projectRepository = projectRepository;
		//this.project = project;
		this.taskRepository = taskRepository;
		this.projectMapper = projectMapper;
	}

	public Project addProject(ProjectDetailsDto projectDto) {
		return projectRepository.save(projectMapper.toProject(projectDto));
	}
	
	public Project updateProject(Integer id, ProjectUpdateRequest request) {
		Project project = projectRepository.findById(id)
				.orElseThrow(() -> new IdNotFoundException("Id not found"));
		
		if(request.getName() != null) {
			project.setName(request.getName());
		}
		
		if(request.getDescription() != null) {
			project.setDescription(request.getDescription());
		}
		
		return projectRepository.save(project);
	}
	
	public void deleteProjectById(Integer id) {
		Project project = projectRepository.findById(id).orElseThrow(()->new IdNotFoundException("enter a valid id"));
		projectRepository.delete(project);
	}
	
	public List<ProjectResponseDto> displayProjectDetails() {
		
		List<Project> projects = projectRepository.findAll();

	    return projects.stream()
	        .map(p -> {
	            List<Task> tasks = taskRepository.findByProjectId(p.getId());
	            return projectMapper.toDto(p, tasks);
	        })
	        .toList();
	}

}
