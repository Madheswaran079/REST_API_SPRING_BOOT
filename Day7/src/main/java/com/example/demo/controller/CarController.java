package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Car;
import com.example.demo.service.CarService;

@RestController
public class CarController {

	@Autowired
	CarService cs;
	
	@PostMapping("/")
	public boolean addData(@RequestBody List<Car> c) {
		try {
			cs.postData(c);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	@GetMapping("/owners/{owners}")
	public List<Car> readByOwners(@PathVariable(value = "owners") int o){
		return cs.getByOwners(o);
	}
	
	@GetMapping("/address/{address}")
	public List<Car> readByAddress(@PathVariable(value = "address") String o){
		return cs.getByAddress(o);
	}
	
	@GetMapping("/carName/{carName}")
	public List<Car> readBycarName(@PathVariable(value = "carName") String o){
		return cs.getByCarName(o);
	}
	
	@GetMapping("/owners/{owners}/carType/{carType}")
	public List<Car> readByOwnersAndCarType(@PathVariable(value = "owners") int o,@PathVariable(value = "carType") String ct){
		return cs.getByOwnersAndCarType(o,ct);
	}
}
