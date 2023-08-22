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

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService ss;
	
	@PostMapping("/create")
	public boolean addData(@RequestBody List<Student> s) {
		try{
			ss.postData(s);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	@GetMapping("/read")
	public Optional<Student> readData(@RequestParam(value = "id") int id) {
		return ss.getData(id);
	}
	
	@GetMapping("/readAll")
	public List<Student> readAllData() {
		return ss.getAllData();
	}
	
	@PutMapping("/update")
	public Student updateData(@RequestParam(value = "id")int id, @RequestBody Student s) {
		return ss.putData(id,s);
	}
	
	@DeleteMapping("/delete")
	public boolean deleteData(@RequestParam int id) {
		if(ss.deleteData(id)) {
			return true;
		}
		return false;
	}
}
