package com.dk.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dk.springboot.entities.Product;

public interface ProductRepository  extends JpaRepository<Product, Integer>{

}
