package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Advertisement;
import com.example.demo.service.AdService;



@RestController
public class AdController {

	@Autowired
	AdService ads;
	
	
	@GetMapping("/readAD")
	public Optional<Advertisement> readData(@RequestParam(value = "orderId") int id) {
		return ads.getById(id);
	}
	@GetMapping("/readAllAD")
	public List<Advertisement> readAllData() {
		return ads.getAll();
	}
	
	@PostMapping("/createAD")
	public String addData(Advertisement ad) {
		try{
			ads.postData(ad);
			return "Order placed successfully..!";
		}
		catch(Exception e){
			return "Order failed";
		}
	}
	@PostMapping("/createAllAD")
	public String addData(@RequestBody List<Advertisement> ad) {
		try{
			ads.postAll(ad);
			return "Order placed successfully..!";
		}
		catch(Exception e){
			return "Order failed";
		}
	}
	
	@PutMapping("/updateAD")
	public Advertisement updateData(@RequestParam(value = "orderId")int id, @RequestBody Advertisement ad) {
		return ads.putData(id,ad);
	}
	
	@DeleteMapping("/deleteAD")
	public boolean deleteData(@RequestParam(value = "orderId")int id) {
		if(ads.deleteData(id)) {
			return true;
		}
		return false;
	}
}
