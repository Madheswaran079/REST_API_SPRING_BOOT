package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Child;
import com.example.demo.repository.ChildRepo;

@Service
public class ChildService {

	@Autowired
	ChildRepo cr;
	
	//post the data as an object
	public Child postData(Child c) {
		return cr.save(c);
	}
	
	//get data in sorted order
	public List<Child> getSortedData(String field) {
		return cr.findAll(Sort.by(Sort.DEFAULT_DIRECTION, field));
	}
	//get data in pages
	public List<Child> getPage(int pgNo,int pgSize) {
		Page<Child> p = cr.findAll(PageRequest.of(pgNo, pgSize));
		return p.getContent();
	}
	//get data in pages in sorted order
	public List<Child> getSortedDataInPage(int pgNo,int pgSize,String field) {
		Sort s = Sort.by(Sort.DEFAULT_DIRECTION, field);
		Page<Child> p = cr.findAll(PageRequest.of(pgNo, pgSize, s));
		return p.getContent();
	}
	
}
