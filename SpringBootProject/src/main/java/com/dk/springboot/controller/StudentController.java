package com.dk.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dk.springboot.entities.Student;
import com.dk.springboot.helper.ResponseStructure;
import com.dk.springboot.repository.StudentRepository;

@RestController
public class StudentController {
	

	@Autowired
	StudentRepository sr;
	
	@PostMapping("/save")
	public ResponseStructure<Student> saveStudent(@RequestBody Student student) {
		sr.save(student);
	ResponseStructure<Student> rs = new ResponseStructure<Student>();
	rs.setStatuseCode(HttpStatus.CREATED.value());
	rs.setData(student);
	rs.setMessage("data saved Successfully");
	return rs;
	}
	@GetMapping("/fetchdatabyid")
	public ResponseStructure<Student> fetchDatabyId(@RequestParam("id")int id)
	{
		try {
			Student student  =	sr.findById(id).get();
			
			ResponseStructure<Student> rs = new ResponseStructure<Student>();
			rs.setStatuseCode(HttpStatus.FOUND.value());
		
			rs.setData(student);
			rs.setMessage("data found");
			return rs;
			
		} catch (Exception e) {
			ResponseStructure<Student> rs = new ResponseStructure<Student>();
			rs.setStatuseCode(HttpStatus.NOT_FOUND.value());
		
			rs.setData(null);
			rs.setMessage("data not found ");
			return rs;
		}
	}

	@GetMapping("/fetchdatabyname")
	public ResponseStructure<List<Student>> fetchDatabyName(@RequestParam("name")String name)
	{
		try {
			List<Student> student  =	sr.findByName(name);
			
			ResponseStructure<List<Student>> rs = new ResponseStructure<List<Student>>();
			rs.setStatuseCode(HttpStatus.FOUND.value());
		
			rs.setData(student);
			rs.setMessage("data found");
			return rs;
			
		} catch (Exception e) {
			ResponseStructure<List<Student>> rs = new ResponseStructure<List<Student>>();
			rs.setStatuseCode(HttpStatus.NOT_FOUND.value());
		
			rs.setData(null);
			rs.setMessage("data not found ");
			return rs;
		}
	}
	
	@GetMapping("/fetchdatabyage")
	public ResponseStructure<List<Student>> fetchDatabyAge(@RequestParam("age")int age)
	{
		try {
			List<Student> student  =	sr.findByAge(age);
			
			ResponseStructure<List<Student>> rs = new ResponseStructure<List<Student>>();
			rs.setStatuseCode(HttpStatus.FOUND.value());
		
			rs.setData(student);
			rs.setMessage("data found");
			return rs;
			
		} catch (Exception e) {
			ResponseStructure<List<Student>> rs = new ResponseStructure<List<Student>>();
			rs.setStatuseCode(HttpStatus.NOT_FOUND.value());
		
			rs.setData(null);
			rs.setMessage("data not found ");
			return rs;
		}
	}
	
	@GetMapping("/fetchdatabycourse")
	public ResponseStructure<List<Student>> fetchDatabyCourse(@RequestParam("Course")String course)
	{
		try {
			List<Student> student  =	sr.findByCourse(course);
			
			ResponseStructure<List<Student>> rs = new ResponseStructure<List<Student>>();
			rs.setStatuseCode(HttpStatus.FOUND.value());
		
			rs.setData(student);
			rs.setMessage("data found");
			return rs;
			
		} catch (Exception e) {
			ResponseStructure<List<Student>> rs = new ResponseStructure<List<Student>>();
			rs.setStatuseCode(HttpStatus.NOT_FOUND.value());
		
			rs.setData(null);
			rs.setMessage("data not found ");
			return rs;
		}
	}
	
	
	
	
}