package com.gsrr.EmployeeManagment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	//@GeneratedValue
	private Integer id;
	private String name;
	private Double salary;
	private String department;
	
	
	public Employee() {
		
	}
	
	public Employee(Integer id, String name, Double salary, String department) {
		this.id =  id;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getSalary() {
		return salary;
	}


	public void setSalary(Double salary) {
		this.salary = salary;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	@Override
	public String toString() {
		return "EMPLOYEE DETAILS\nid=" + id + "\n name=" + name + "\n salary=" + salary + "\n department=" + department + "\n";
	}
	
	
	
}
