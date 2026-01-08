package com.gsrr.ExampleApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsrr.ExampleApplication.School;

public interface SchoolRepository extends JpaRepository<School, Integer>{


}
