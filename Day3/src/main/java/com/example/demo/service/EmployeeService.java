package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo er;
	
	public Employee setValues(Employee e) {
		return er.save(e);
	}
	
	public List<Employee> showValues() {
		return er.findAll();
	}
	
	public Optional<Employee> showEmployee(int id) {
		return er.findById(id);
	}
}
