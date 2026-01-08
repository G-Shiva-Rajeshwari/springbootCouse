package com.gsrr.ExampleApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class StudentProfile {

	@Id
	private Integer id;
	private String bio;
	
	@OneToOne
	@JoinColumn(
			name = "student_id"
			)
	
	private Student student;
	
	public StudentProfile() {
		super();
	}
	public StudentProfile(Integer id, String bio) {
		super();
		this.id = id;
		this.bio = bio;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	
}
