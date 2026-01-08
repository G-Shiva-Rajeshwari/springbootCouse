package com.gsrr.SimpleWebApp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.gsrr.SimpleWebApp.model.Product;

@Service
public class ProductService {

	List<Product> products = new ArrayList<>(Arrays.asList(
			new Product(101, "Iphone",50000),
			new Product(102, "realme",66000),
			new Product(103, "samsung",48000)));
	
	public List<Product> getAllProducts(){
		return products;
	}

	public Product getProductById(int prodId) {
		return products.stream().filter(p -> p.getProdId() == prodId).findFirst().orElse(new Product(100, "No Item", 0));
	}
	
	public void addProduct( Product prod) {
		System.out.println(prod);
		products.add(prod);
	}
	
	public void updateProduct(Product prod) {
		int idx=0;
		for(int i=0;i<products.size();i++)
			if(products.get(i).getProdId() == prod.getProdId())
				idx=i;
			products.set(idx, prod);	
	}

	public void deleteByName(String prodName) {
		for(int i=0;i<products.size();i++) {
			if(products.get(i).getProdName() == prodName)
				products.remove(i);
		}
		
	}
	
	
}
