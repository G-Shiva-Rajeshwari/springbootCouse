package com.gsrr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gsrr.lombok.Author;

import jakarta.transaction.Transactional;

public interface AuthorRepository extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author>{
	
	List<Author> findByNamedQuery(@Param("age") int age);
	
	@Modifying
	@Transactional
	void updateByNamedQuery(@Param("age") int age);
	
	@Modifying
	@Transactional
	@Query("update Author a set a.age = :age where a.id = :id")
	int updateAuthor(int age, int id);
	
	@Modifying
	@Transactional
	@Query("update Author a set a.age = :age")
	int updateAllAuthor(int age);
	
	List<Author> findAllByfirstname(String fn);
	
	List<Author> findAllByfirstnameIgnoreCase(String fn);
	
	//'%al%'
	List<Author> findAllByfirstnameContainingIgnoreCase(String fn);
	
	//'al%'
	List<Author> findAllByfirstnameStartsWithIgnoreCase(String fn);
	
	//'%al'
	List<Author> findAllByfirstnameEndsWithIgnoreCase(String fn);

	//('abc', 'aab', 'coding')
	List<Author> findAllByfirstnameInIgnoreCase(List<String> fn);

}
