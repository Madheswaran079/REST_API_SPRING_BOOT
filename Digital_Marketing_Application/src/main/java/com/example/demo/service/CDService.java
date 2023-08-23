package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CompanyDetails;
import com.example.demo.repository.CDRepo;

@Service
public class CDService {

	@Autowired
	CDRepo cdr;
	
	public Optional<CompanyDetails> getById(int id) {
		return cdr.findById(id);
	}
	public List<CompanyDetails> getAll() {
		return cdr.findAll();
	}
	
	public CompanyDetails postData(CompanyDetails pd) {
		return cdr.save(pd);
	}
	public List<CompanyDetails> postAll(List<CompanyDetails> pd){
		return (List<CompanyDetails>)cdr.saveAll(pd);
	}
	
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
	
	public boolean deleteData(int id) {
		cdr.deleteById(id);
		return true;
	}
}
