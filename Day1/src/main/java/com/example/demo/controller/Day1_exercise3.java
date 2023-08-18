package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Day1_exercise3 {

	@Value("${const}")
	private String myFavColor;
	
	@GetMapping("/color")
	public String getMyFav() {
		return "My favourite color is " + myFavColor ;
	}
}
