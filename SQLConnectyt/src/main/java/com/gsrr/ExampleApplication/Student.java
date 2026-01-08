package com.gsrr.ExampleApplication;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name = "Demo")
@Entity
public class Student {

	@Id
	private Integer id;
	//@Column(name = "c_name")
	private String firstname;
	private String lastname;
	private int age;
	
	@Column(unique = true)
	private String email;
	
	@Column(updatable = false
			//insertable
			)
	private String some_column;

	public Integer getId() {
		return id;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSome_column() {
		return some_column;
	}

	public void setSome_column(String some_column) {
		this.some_column = some_column;
	}
	
	
}
