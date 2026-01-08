package com.gsrr.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gsrr.springboot.learn_jpa_and_hibernate.course.Course;

@Repository
public class CourseJdbcRepository {

	@Autowired
	private JdbcTemplate springJdbcTemplete;
	
	private static String INSERT_QUERY = 
			"""
			INSERT INTO course (id, name, author)
			VALUES (?,?,?);

			""";
	
	private static String DELETE_QUERY = 
			"""
			DELETE FROM course WHERE 
			id=?;

			""";
	
	private static String SELECT_QUERY = 
			"""
			SELECT * FROM course  
			WHERE id=?;

			""";
	
//	public void insert() {
//		springJdbcTemplete.update(INSERT_QUERY);
//	}
	
	public void insert(Course course) {
		springJdbcTemplete.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
	}
	
	public void deleteById(long id) {
		springJdbcTemplete.update(DELETE_QUERY,id);
	}
	
	public Course findById(long id) {
		return springJdbcTemplete.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class),id);
		//ResultSet -> Bean => Row Mapper =>
	}
	
}
