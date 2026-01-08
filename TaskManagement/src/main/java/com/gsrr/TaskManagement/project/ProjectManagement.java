package com.gsrr.TaskManagement.project;

import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gsrr.TaskManagement.project.dto.ProjectDetailsDto;
import com.gsrr.TaskManagement.project.dto.ProjectResponseDto;
import com.gsrr.TaskManagement.project.dto.ProjectUpdateRequest;
import com.gsrr.TaskManagement.tasks.Task;
import com.gsrr.TaskManagement.tasks.TaskRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/projects")
public class ProjectManagement {

	private final ProjectRepository projectRepo;
	private final ProjectService projService;
	
	
	public ProjectManagement(ProjectRepository projectRepo, ProjectService projService) {
		super();
		this.projectRepo = projectRepo;
		this.projService = projService;
	}


	@PostMapping("/add")
	public ResponseEntity<Project> addProject(@RequestBody @Valid ProjectDetailsDto project) {
		return ResponseEntity.ok(projService.addProject(project));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateById(
			@PathVariable Integer id,
			@RequestBody ProjectUpdateRequest request
			) {
		projService.updateProject(id, request);
		return ResponseEntity.ok("project updated successfully");
	}
	
	@DeleteMapping("/deleteProject/{id}")
	public ResponseEntity<String> deleteProjectById(@PathVariable Integer id) {
		projService.deleteProjectById(id);
		return ResponseEntity.ok("success");
	}
	
	@GetMapping("/displayProjects")
	public ResponseEntity<List<ProjectResponseDto>> displayProjectDetails(){
		return ResponseEntity.ok(projService.displayProjectDetails());
		}
	}
	
