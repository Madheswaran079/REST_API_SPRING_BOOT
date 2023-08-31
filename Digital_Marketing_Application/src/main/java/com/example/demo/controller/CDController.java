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

import com.example.demo.model.CompanyDetails;
import com.example.demo.service.CDService;

@RestController
public class CDController {

	@Autowired
	CDService cds;
	
	
	@GetMapping("/readCD")
	public Optional<CompanyDetails> readData(@RequestParam(value = "customerId") int id) {
		return cds.getById(id);
	}
	@GetMapping("/readAllCD")
	public List<CompanyDetails> readAllData() {
		return cds.getAll();
	}
	
	@PostMapping("/createCD")
	public String addData(CompanyDetails cd) {
		try{
			cds.postData(cd);
			return "Details added successfully..!";
		}
		catch(Exception e){
			return "Failed to add :(";
		}
	}
	@PostMapping("/createAllCD")
	public String addData(@RequestBody List<CompanyDetails> cd) {
		try{
			cds.postAll(cd);
			return "Details added successfully..!";
		}
		catch(Exception e){
			return "Failed to add :(";
		}
	}
	
	@PutMapping("/updateCD")
	public CompanyDetails updateData(@RequestParam(value = "customerId")int id, @RequestBody CompanyDetails cd) {
		return cds.putData(id,cd);
	}
	
	@DeleteMapping("/deleteCD")
	public String deleteData(@RequestParam(value = "customerId") int id) {
		if(cds.deleteData(id)) {
			return "Details of customerId " + id + " deleted successfully.";
		}
		return "Failed to delete";
	}
	
	@GetMapping("/sortCD/{field}")
	public List<CompanyDetails> sortByField(@PathVariable(value = "field") String field) {
		return cds.sortData(field);
	}
	
	@GetMapping("/pageCD/{pgNum}/{pgSize}")
	public List<CompanyDetails> getAsPage(@PathVariable(value = "pgNum") int pgNum, @PathVariable(value = "pgSize") int pgSize) {
		return cds.getPage(pgNum, pgSize);
	}
	
	@GetMapping("/selectCD/{value}")
	public List<CompanyDetails> selectTheData(@PathVariable(value = "value") int value) {
		return cds.selectByData(value);
	}
	
	@PutMapping("/updateQCD/{changeValue}/{checkValue}")
	public String updateTheData(@PathVariable(value = "changeValue")float changeValue,@PathVariable(value = "checkValue")String checkValue) {
		if(cds.updateValue(changeValue,checkValue)) {
			return "Updated successfully..!";
		}
		return "Can not update";
	}
	
}
