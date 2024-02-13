package com.dk.springboot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // restController = Controller + Response-body
public class HomeController {
	@PostMapping("/hi")
	public String  m1() {
		 
		return "this is the first program in spring boot project";
	}
	@PostMapping("/person")
	public String m3() {
		return (new Person(1,"linga", 19)).toString();
	}

}
