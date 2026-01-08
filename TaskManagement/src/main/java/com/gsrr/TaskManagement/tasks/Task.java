package com.gsrr.TaskManagement.tasks;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gsrr.TaskManagement.project.Project;
import com.gsrr.TaskManagement.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
public class Task {

	@Id
	private Integer id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(length = 50)
	private String description;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING) // Use STRING to store enum names as text in DB
    private Status status;
	
	@Column(nullable = false)
	 @Enumerated(EnumType.STRING) 
	    private Priority priority;
	
	public enum Status{TODO, IN_PROGRESS, DONE}
	public enum Priority{LOW, MEDIUM, HIGH}
	
	@DateTimeFormat(style = "dd-MM-yyyy")
	private LocalDateTime dateofcreation;
	
	private Integer completeWithin;
	
	@ManyToOne(optional = true)
	@JsonBackReference("user-task")
	@JoinColumn(name = "user_id", nullable = true)
	private User user;
	
	@ManyToOne(optional = true)
	@JsonBackReference("project-task")
	@JoinColumn(name="project_id", nullable = true)
	private Project project;
}
