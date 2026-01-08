package com.gsrr.springboot.learnspringboot.courses.bean.controller;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Course {
	

	@Id
//	@GeneratedValue
private int id;
	//@Column(name = "subject")
private String course;
private String author;

public Course() {}

public Course(int id, String course, String author) {
	super();
	this.id = id;
	this.course = course;
	this.author = author;
}

public int getId() {
	return id;
}

public String getCourse() {
	return course;
}

public String getAuthor() {
	return author;
}

public void setId(int id) {
	this.id = id;
}

public void setCourse(String course) {
	this.course = course;
}

public void setAuthor(String author) {
	this.author = author;
}
public String toString() {
	return "[ id "+getId()+" name "+getCourse()+" author "+getAuthor()+" ]";
}
}

//insert into course(id, author, subject)
//values (23,'shiva','learn java');

