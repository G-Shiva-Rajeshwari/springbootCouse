package com.gsrr.ExampleApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsrr.ExampleApplication.entity.School;

public interface SchoolRepository extends JpaRepository<School, Integer>{


}
