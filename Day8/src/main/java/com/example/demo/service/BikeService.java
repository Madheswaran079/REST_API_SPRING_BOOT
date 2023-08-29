package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Bike;
import com.example.demo.repository.BikeRepo;

@Service
public class BikeService {

	@Autowired
	BikeRepo br;
	
	//post data as list
	public List<Bike> postData(List<Bike> b) {
		return (List<Bike>)br.saveAll(b);
	}
	
	//get data of bike by bikeName
	public Optional<Bike> getByBikeName(String bn) {
		return br.findByBikeName(bn);
	}
	
	//get data of bike by year
	public List<Bike> getByYear(int y) {
		return br.findByYear(y);
	}
		
	//get data of bike by bikeName
	public List<Bike> getByYearOrBikeName(int y, String bn) {
		return br.findByYearOrBikeName(y,bn);
	}
}
