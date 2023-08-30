package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.CompanyDetails;
import com.example.demo.repository.CDRepo;

@Service
public class CDService {

	@Autowired
	CDRepo cdr;
	
	//post
	public CompanyDetails postData(CompanyDetails pd) {
		return cdr.save(pd);
	}
	public List<CompanyDetails> postAll(List<CompanyDetails> pd){
		return (List<CompanyDetails>)cdr.saveAll(pd);
	}
	
	//get
	public Optional<CompanyDetails> getById(int id) {
		return cdr.findById(id);
	}
	public List<CompanyDetails> getAll() {
		return cdr.findAll();
	}
	
	//put
	public CompanyDetails putData(int id, CompanyDetails cd) {
		CompanyDetails exist = cdr.findById(id).orElse(null);
		if(exist != null)
		{
			if(cd.getCustomerId() != 0)
			{
				exist.setCustomerId(cd.getCustomerId());				
			}
			if(cd.getDomain() != null)
			{
				exist.setDomain(cd.getDomain());
			}
			if(cd.getCompanyName() != null)
			{
				exist.setCompanyName(cd.getCompanyName());				
			}
			if(cd.getCompanyEmail() != null)
			{
				exist.setCompanyEmail(cd.getCompanyEmail());				
			}
			if(cd.getStartDate() != null)
			{
				exist.setStartDate(cd.getStartDate());				
			}
			if(cd.getRevenue() != 0)
			{
				exist.setRevenue(cd.getRevenue());				
			}
			if(cd.getBranch() != 0)
			{
				exist.setBranch(cd.getBranch());				
			}
			return cdr.save(exist);
		}
		else {
			return null;
		}
	}
	
	//delete
	public boolean deleteData(int id) {
		cdr.deleteById(id);
		return true;
	}
	
	//sort
	public List<CompanyDetails> sortData(String field) {
		return cdr.findAll(Sort.by(Sort.DEFAULT_DIRECTION, field));
	}
	
	//pagination
	public List<CompanyDetails> getPage(int pgNo,int pgSize) {
		Page<CompanyDetails> p = cdr.findAll(PageRequest.of(pgNo, pgSize));
		return p.getContent();
	}
	
	//select
	public List<CompanyDetails> selectByData(String field,int value) {
		return cdr.selectData(field, value);
	}
	
	//update
	public boolean updateValue(String changeField,String changeValue,String checkField,String checkValue) {
		try {
			cdr.updateData(changeField, changeValue, checkField, checkValue);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
