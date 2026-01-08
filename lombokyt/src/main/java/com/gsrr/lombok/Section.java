package com.gsrr.lombok;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Section{
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	private String SectionOrder;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;
	
	
	@OneToMany(mappedBy = "section")
	private List<Lecture> letures;
	
	
}
