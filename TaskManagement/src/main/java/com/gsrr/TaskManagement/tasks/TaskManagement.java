package com.gsrr.TaskManagement.tasks;

import java.util.List;


import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gsrr.TaskManagement.tasks.dto.FilteringTasksRequest;
import com.gsrr.TaskManagement.tasks.dto.TaskAssignmentRequest;
import com.gsrr.TaskManagement.tasks.dto.TaskDetailsDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskManagement {

	private final TaskRepository taskRepo;
	private final TaskService taskService;
	
	public TaskManagement(TaskRepository taskRepo, TaskService taskService) {
		super();
		this.taskRepo = taskRepo;
		this.taskService = taskService;
	}

	@PostMapping("/add")
	public ResponseEntity<Task> createTask(@RequestBody @Valid TaskDetailsDto task) {
		return ResponseEntity.ok(taskService.createTask(task));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Task> updateTaskStatusAndPriorityByTaskId(@PathVariable Integer id, @RequestBody TaskUpdateRequest request) {
		return ResponseEntity.ok(taskService.updateTaskStatusAndPriorityByTaskId(id, request));
	}
	
	@PutMapping("/assign/{taskId}")
	public ResponseEntity<Task> assignTask(@PathVariable Integer taskId, @RequestBody TaskAssignmentRequest request){
		Task updatedTask = taskService.assignTask(taskId, request.getUserId(),request.getProjectId());
		return ResponseEntity.ok(updatedTask);
	}
	
	@PostMapping("/filterByCondition")
	public ResponseEntity<List<Task>> FilterByCondition(@RequestBody FilteringTasksRequest filterRequest) {
		Specification<Task> spec1 = Specification
    			.where(taskService.findByStatus(filterRequest.getStatus()))
    			.and(taskService.findByPriority(filterRequest.getPriority()))
    			.and(taskService.findByUserId(filterRequest.getUserId()))
    			.and(taskService.findByProjectId(filterRequest.getProjectId()));
    List<Task> tasks = taskRepo.findAll(spec1);
    	return ResponseEntity.ok(tasks);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> DeleteTaskById(@PathVariable Integer id) {
		taskService.DeleteTaskById(id);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
