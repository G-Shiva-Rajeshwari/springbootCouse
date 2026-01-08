package com.gsrr.ExampleApplication;

import jakarta.persistence.Entity;

@Entity
public class School {

	@jakarta.persistence.Id
	private Integer id;
	private String name;
	
	public School() {
		super();
	}
	public School(Integer id, String name) {
		this.id = id;
		this.name = name;
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


}
