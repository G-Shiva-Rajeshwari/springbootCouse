package com.gsrr.lombok;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

//@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "courses")
@Builder
@Entity
@NamedQueries(
		{
			@NamedQuery(
					name = "Author.findByNamedQuery",
					query = "select a from Author a where a.age >= :age"
					),

			@NamedQuery(
					name = "Author.updateByNamedQuery",
					query = "update Author a set a.age = :age"
					)

		}
		)

public class Author{

//	@GeneratedValue(
//			strategy = GenerationType.SEQUENCE,
//			generator = "author_sequence"
//			)
//	@SequenceGenerator(
//			name = "author_sequence",
//			sequenceName = "author_sequence",
//			allocationSize = 1
//			)
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(
			name = "f_name",
			length = 30
			)
	private String firstname;
	private String lastname;
	
	@Column(
			unique = true,
			nullable = false
			)
	private String email;
	private Integer age;
	
//	@Column(
//			updatable = false,
//			nullable = false
//			)
//	private LocalDateTime createdAt;
//	
//	@Column(
//			insertable = false
//			)
//	private LocalDateTime lastModified;

	@ManyToMany(mappedBy = "authors")
	private List<Course> courses;
	
	//@OneToMany(mappedBy = "author", fetch = FetchType.EAGER)

//	public Author() {
//		super();
//	}

	public Author(String firstname, String lastname, String email, Integer age) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.age = age;
	}
	
//	public Author(Integer id, String firstname, String lastname, String email, Integer age, List<Course> courses) {
//		super();
//		this.id = id;
//		this.firstname = firstname;
//		this.lastname = lastname;
//		this.email = email;
//		this.age = age;
//		this.courses = courses;
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
//	public String getFirstname() {
//		return firstname;
//	}
//
//	public void setFirstname(String firstname) {
//		this.firstname = firstname;
//	}
//
//	public String getLastname() {
//		return lastname;
//	}
//
//	public void setLastname(String lastname) {
//		this.lastname = lastname;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public Integer getAge() {
//		return age;
//	}
//
//	public void setAge(Integer age) {
//		this.age = age;
//	}
//
//	public List<Course> getCourses() {
//		return courses;
//	}
//
//	public void setCourses(List<Course> courses) {
//		this.courses = courses;
//	}

	
}
