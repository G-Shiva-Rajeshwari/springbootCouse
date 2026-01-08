package com.gsrr.DemoApp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gsrr.DemoApp.model.Product;
import com.gsrr.DemoApp.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService ps;
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		return ps.getAllProducts();
	}
	
	@GetMapping("/products/{prodId}")
	
	public Product getTheProduct(@PathVariable int prodId) {
		return ps.getProductById(prodId);
	}
	
	
	@PostMapping("/products")
	public void addProduct(@RequestBody Product prod) {
		ps.addProduct(prod);
	}

	@PutMapping("/products")
	public void updateProduct(@RequestBody Product prod) {
		ps.updateProduct(prod);
	}
	
	@DeleteMapping("/products/{prodName}")
	public void deleteMapping(@PathVariable String prodName) {
		ps.deleteByprodName(prodName);
	}
}
