package com.dk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import jakarta.persistence.Entity;

@SpringBootApplication(scanBasePackages = "com.dk")
@EntityScan(basePackages = "com.dk")
@EnableJpaRepositories(basePackages = "com.dk")
public class SpringBootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectApplication.class, args);
		System.out.println("spring boot is started");
	}
	

}

