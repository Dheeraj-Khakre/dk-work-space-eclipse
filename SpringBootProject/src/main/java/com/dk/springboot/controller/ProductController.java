package com.dk.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dk.springboot.entities.Product;
import com.dk.springboot.helper.ResponseStructure;
import com.dk.springboot.repository.ProductRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class ProductController {
	@Autowired
	ProductRepository pr;
	
	
	@PostMapping("/saveproduct")
	public ResponseStructure<Product> postMethodName(@RequestBody Product product) {
		pr.save(product);
		ResponseStructure<Product> rs=new ResponseStructure<Product>();
		rs.setData(product);
		rs.setMessage(" product save successfully");
		rs.setStatuseCode(HttpStatus.CREATED.value());
		return rs;
		
	}
	

}
