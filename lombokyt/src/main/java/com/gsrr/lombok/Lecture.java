package com.gsrr.lombok;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Lecture{

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	
	@OneToOne
	@JoinColumn(name = "resource_id")
	private Resource resource;

	@ManyToOne
	@JoinColumn(name = "section_id")
	private Section section; 
	
//	public Lecture() {
//		super();
//	}
//
//	public Lecture(Integer id, String name, Resource resource) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.resource = resource;
//	}
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public Resource getResource() {
//		return resource;
//	}
//
//	public void setResource(Resource resource) {
//		this.resource = resource;
//	}
//	
	
}
