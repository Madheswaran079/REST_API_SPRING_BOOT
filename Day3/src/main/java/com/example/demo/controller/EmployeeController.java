package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService eser;
	
	@PostMapping("/setDetails")
	public Employee add(@RequestBody Employee e) {
		return eser.setValues(e);
	}
	
	@GetMapping("/showDetails")
	public List<Employee> show(){
		return eser.showValues();
	}
	
	@GetMapping("/showEmployee/{id}")
	public Optional<Employee> showEmployee(@PathVariable(value = "id") int id) {
		return eser.showEmployee(id);
	}
}
