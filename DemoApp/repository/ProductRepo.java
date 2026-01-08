package com.gsrr.DemoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.gsrr.DemoApp.model.Product;

import jakarta.transaction.Transactional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

	@Modifying
	@Transactional
	void deleteByprodName(String prodName);

}
