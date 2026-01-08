package com.gsrr.lombok;

import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Course{

	@Id
	@GeneratedValue
	private Integer id;
	
	private String title;
	private String description;
	
	@ManyToMany
	@JoinTable(
			name = "authors_courses",
			joinColumns = {
					@JoinColumn(name = "course_id")
			},
			inverseJoinColumns = {
					@JoinColumn(name = "author_id")
			}
			)
	private List<Author> authors;
	
	@OneToMany(mappedBy = "course")
	private List<Section> sections;

	
	
}