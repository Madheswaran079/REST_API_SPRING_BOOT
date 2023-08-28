package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Child;
import com.example.demo.service.ChildService;

@RestController
public class ChildController {

	@Autowired
	ChildService cs;
	
	@PostMapping("/insert")
	public boolean addData(@RequestBody Child c) {
		try {
			cs.postData(c);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	@GetMapping("/read/sort")
	public List<Child> readById(@RequestParam(value = "field") String field) {
		return cs.getSortedData(field);
	}
	@GetMapping("/read/page")
	public List<Child> readThePage(@RequestParam(value = "pgNum")int pgNum, @RequestParam(value = "pgSize")int pgSize) {
		return cs.getPage(pgNum, pgSize);
	}
	@GetMapping("read/page/sort")
	public List<Child> readThePageSorted(@RequestParam(value = "pgNum")int pgNum, @RequestParam(value = "pgSize")int pgSize, @RequestParam(value = "field")String field) {
		return cs.getSortedDataInPage(pgNum, pgSize, field);
	};
}
