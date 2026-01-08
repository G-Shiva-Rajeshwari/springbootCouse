package com.gsrr.ExampleApplication.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	private Integer age = 0;
	
	@OneToOne(
			mappedBy = "student",
			cascade = CascadeType.ALL 
			)
	
	private StudentProfile studentprofile;
	
	
	@ManyToOne
	@JoinColumn(
			name = "school_id"
			)
	@JsonBackReference
	private School school;

	
	public StudentProfile getStudentprofile() {
		return studentprofile;
	}

	public void setStudentprofile(StudentProfile studentprofile) {
		this.studentprofile = studentprofile;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Integer getId() {
		return id;
	}

	public Student() {
		super();
	}

	public Student(Integer id, String firstname, String lastname, String email, int age, StudentProfile studentprofile) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.age = age;
		this.studentprofile = studentprofile;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
