package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PersonalDetails;
import com.example.demo.service.PDService;

@RestController
public class PDController {

	@Autowired
	PDService pds;
	
	
	@GetMapping("/readPD")
	public Optional<PersonalDetails> readData(@RequestParam(value = "id") int id) {
		return pds.getById(id);
	}
	@GetMapping("/readAllPD")
	public List<PersonalDetails> readAllData() {
		return pds.getAll();
	}
	
	@PostMapping("/createPD")
	public String addData(PersonalDetails pd) {
		try{
			pds.postData(pd);
			return "Details added successfully..!";
		}
		catch(Exception e){
			return "Failed to add :(";
		}
	}
	@PostMapping("/createAllPD")
	public String addData(@RequestBody List<PersonalDetails> pd) {
		try{
			pds.postAll(pd);
			return "Details added successfully..!";
		}
		catch(Exception e){
			return "Failed to add :(";
		}
	}
	
	@PutMapping("/updatePD")
	public PersonalDetails updateData(@RequestParam(value = "id")int id, @RequestBody PersonalDetails pd) {
		return pds.putData(id,pd);
	}
	
	@DeleteMapping("/deletePD")
	public String deleteData(@RequestParam(value = "id") int id) {
		if(pds.deleteData(id)) {
			return "Details of id " + id + " deleted successfully.";
		}
		return "Failed to delete";
	}
	
	@GetMapping("/sortPD/{field}")
	public List<PersonalDetails> sortByField(@PathVariable(value = "field") String field) {
		return pds.sortData(field);
	}
	
	@GetMapping("/pagePD/{pgNum}/{pgSize}")
	public List<PersonalDetails> getAsPage(@PathVariable(value = "pgNum") int pgNum, @PathVariable(value = "pgSize") int pgSize) {
		return pds.getPage(pgNum, pgSize);
	}
	
	@GetMapping("/selectPD/{value}")
	public List<PersonalDetails> selectTheData(@PathVariable(value = "value") String value) {
		return pds.selectByData(value);
	}
	
	@PutMapping("/updateQPD/{changeValue}/{checkValue}")
	public String updateTheData(@PathVariable(value = "changeValue")long changeValue, @PathVariable(value = "checkValue")String checkValue) {
		if(pds.updateValue(changeValue,checkValue)) {
			return "Updated successfully..!";
		}
		return "Can not update";
	}
	
//	@DeleteMapping("/deleteQPD/{name}")
//	public String deleteTheData(@PathVariable(value = "name") String name) {
//		try{
//			pds.deleteValue(name);
//			return "Deleted successfully..!";
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//			return "Can not delete";
//		}
//	}
}
