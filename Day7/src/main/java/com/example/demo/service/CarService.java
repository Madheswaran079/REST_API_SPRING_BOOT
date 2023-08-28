package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepo;

@Service
public class CarService {

	@Autowired
	CarRepo cr;
	
	//post the data as a list
	public List<Car> postData(List<Car> c) {
//		return (List<Car>)cr.saveAll(c);
		return (List<Car>)cr.saveAll(c);
	}
	
	//get by owners
	public List<Car> getByOwners(int o) {
		return cr.findByOwners(o);
	}
	
	//get by address
	public List<Car> getByAddress(String a) {
		return cr.findByAddress(a);
	}
	
	//get by car name 
	public List<Car> getByCarName(String c) {
		return cr.findByCarName(c);
	}
	
	//get by owners and car type
	public List<Car> getByOwnersAndCarType(int o, String ct) {
		return cr.findByOwnersAndCarType(o,ct);
	}
}
