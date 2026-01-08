package com.gsrr.TaskManagement.user;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gsrr.TaskManagement.tasks.Task;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Column(
			unique = true,
			nullable = false
			)
	@Id
	private Integer id;
	
	@Column(
			nullable = false
			)
	private String name;
	@Column(
			nullable = false
			)
	private String email;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonManagedReference("user-task")
	private List<Task> tasks;
}
