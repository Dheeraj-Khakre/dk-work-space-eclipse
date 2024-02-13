package com.dk.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dk.springboot.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	List<Student> findByName(String name);
	
	List<Student> findByAge(int name);

	List<Student> findByCourse(String course);
}
