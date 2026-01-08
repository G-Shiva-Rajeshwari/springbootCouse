package com.gsrr.springboot.learnspringboot.courses.bean.controller;

public class Course {
private int id;
private String course;
private String author;

public Course(int id, String course, String author) {
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

public String toString() {
	return "[ id "+getId()+" name "+getCourse()+" author "+getAuthor()+" ]";
}
}
