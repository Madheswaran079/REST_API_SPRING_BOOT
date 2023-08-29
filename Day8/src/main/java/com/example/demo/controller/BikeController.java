package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Bike;
import com.example.demo.service.BikeService;

@RestController
public class BikeController {

	@Autowired
	BikeService bs;
	
	@PostMapping("/")
	public boolean addData(@RequestBody List<Bike> b) {
		try {
			bs.postData(b);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	@GetMapping("/year/{y}")
	public List<Bike> readByYear(@PathVariable(value = "y") int y) {
		return bs.getByYear(y);
	}
	
	@GetMapping("/bikeName/{bn}")
	public Optional<Bike> readByBikeName(@PathVariable(value = "bn") String bn) {
		return bs.getByBikeName(bn);
	}
	
	@GetMapping("/year/{y}/bikeName/{bn}")
	public List<Bike> readByYearOrBikeName(@PathVariable(value = "y") int y, @PathVariable(value = "bn") String bn) {
		return bs.getByYearOrBikeName(y,bn);
	}
}
