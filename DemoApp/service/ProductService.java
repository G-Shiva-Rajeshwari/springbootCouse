package com.gsrr.DemoApp.service;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.gsrr.DemoApp.model.Product;
import com.gsrr.DemoApp.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	ProductRepo repo;
	
	public List<Product> getAllProducts(){
		return repo.findAll();
	}

	public Product getProductById(int prodId) {
		return repo.findById(prodId).orElse(new Product());
	}
	
	public void addProduct( Product prod) {
		repo.save(prod);
	}
	
	public void updateProduct(Product prod) {
		repo.save(prod);
	}

	public void deleteByprodName(String prodName) {
		repo.deleteByprodName(prodName);
		
	}
	
	
}
