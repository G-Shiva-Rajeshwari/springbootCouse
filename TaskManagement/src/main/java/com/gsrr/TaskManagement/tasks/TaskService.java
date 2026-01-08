package com.gsrr.TaskManagement.tasks;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gsrr.TaskManagement.project.Project;
import com.gsrr.TaskManagement.project.ProjectRepository;
import com.gsrr.TaskManagement.tasks.dto.TaskMapper;
import com.gsrr.TaskManagement.exceptions.IdNotFoundException;
import com.gsrr.TaskManagement.exceptions.ProjectNotFoundException;
import com.gsrr.TaskManagement.exceptions.TaskNotFoundException;
import com.gsrr.TaskManagement.exceptions.UserNotFoundException;
import com.gsrr.TaskManagement.tasks.Task.Priority;
import com.gsrr.TaskManagement.tasks.Task.Status;
import com.gsrr.TaskManagement.tasks.dto.TaskDetailsDto;
import com.gsrr.TaskManagement.user.User;
import com.gsrr.TaskManagement.user.UserRepository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ProjectRepository projectRepo;
	
	@Autowired
	private TaskMapper taskMapper;
	    
	public Task getTaskById(Integer id) {
		return taskRepo.findById(id)
				.orElseThrow(() -> new TaskNotFoundException("task not found"));
	}

	public Task save(Task task) {
		return taskRepo.save(task);
	}

	@Transactional
	public Task assignTask(Integer taskId, Integer userId, Integer projectId) {
		 Task task = taskRepo.findById(taskId)
	                .orElseThrow(() -> new TaskNotFoundException("Task not found"));

	        User user = userRepo.findById(userId)
	                .orElseThrow(() -> new UserNotFoundException("User not found"));

	        Project project = projectRepo.findById(projectId)
	                .orElseThrow(() -> new ProjectNotFoundException("Project not found"));

	        
	        task.setUser(user);
	        task.setProject(project);

	        return taskRepo.save(task);
	}

	public Specification<Task> findByStatus(Status status){ 
		return (
				Root<Task> root,
				CriteriaQuery<?> query,
				CriteriaBuilder builder
				) -> {
					
					if(status == null) {
						return null;
					}
					
					return builder.equal(root.get("status"),status);
				};
		
	}
	
	public Specification<Task> findByPriority(Priority priority){ 
		return (
				Root<Task> root,
				CriteriaQuery<?> query,
				CriteriaBuilder builder
				) -> {
					
					if(priority == null) {
						return null;
					}
					
					return builder.equal(root.get("priority"),priority);
				};
		
	}
	
	public Specification<Task> findByUserId(Integer userId){ 
		return (
				Root<Task> root,
				CriteriaQuery<?> query,
				CriteriaBuilder builder
				) -> {
					
					if(userId == null) {
						return null;
					}
					
					return builder.equal(root.get("user").get("id"), userId);
				};
		
	}
	
	public Specification<Task> findByProjectId(Integer projectid){ 
		return (
				Root<Task> root,
				CriteriaQuery<?> query,
				CriteriaBuilder builder
				) -> {
					
					if(projectid == null) {
						return null;
					}
					
					return builder.equal(root.get("project").get("id"),projectid);
				};
	}
	
	public void DeleteTaskById(Integer id) {
		taskRepo.deleteById(id);
	}
	
	public Task updateTaskStatusAndPriorityByTaskId(Integer id, TaskUpdateRequest request) {
		Task task = taskRepo.findById(id).orElseThrow(()->new IdNotFoundException("taskId not found id: "+id));
		
		task.setStatus(request.getStatus());
		task.setPriority(request.getPriority());
		
		Task updatedTask = taskRepo.save(task);
		
		return updatedTask;
	}

	public Task createTask(TaskDetailsDto dto) {
		return taskRepo.save(taskMapper.toTask(dto));
	}
	
}
