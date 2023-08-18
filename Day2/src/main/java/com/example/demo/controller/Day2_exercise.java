package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Day2_exercise {

	@Value("${var}")
	private String taste;
	
	@GetMapping("/disp")
	public String display() {
		return "Bloody " + taste ;
	}
}
