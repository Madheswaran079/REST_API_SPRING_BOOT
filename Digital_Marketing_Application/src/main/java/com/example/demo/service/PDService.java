package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.PersonalDetails;
import com.example.demo.repository.PDRepo;

@Service
public class PDService {

	@Autowired
	PDRepo pdr;
	
	//post
	public PersonalDetails postData(PersonalDetails pd) {
		return pdr.save(pd);
	}
	public List<PersonalDetails> postAll(List<PersonalDetails> pd){
		return (List<PersonalDetails>)pdr.saveAll(pd);
	}
	
	//get
	public Optional<PersonalDetails> getById(int id) {
		return pdr.findById(id);
	}
	public List<PersonalDetails> getAll() {
		return pdr.findAll();
	}
	
	//put
	public PersonalDetails putData(int id, PersonalDetails pd) {
		PersonalDetails exist = pdr.findById(id).orElse(null);
		if(exist != null)
		{
			if(pd.getId() != 0)
			{
				exist.setId(pd.getId());				
			}
			if(pd.getUserName() != null)
			{
				exist.setUserName(pd.getUserName());				
			}
			if(pd.getPassword() != null)
			{
				exist.setPassword(pd.getPassword());
			}
			if(pd.getName() != null)
			{
				exist.setName(pd.getName());				
			}
			if(pd.getPhoneNum() != 0)
			{
				exist.setPhoneNum(pd.getPhoneNum());				
			}
			if(pd.getEmail() !=null)
			{
				exist.setEmail(pd.getEmail());				
			}
			if(pd.getAddress() !=null)
			{
				exist.setAddress(pd.getAddress());				
			}
			return pdr.save(exist);
		}
		else {
			return null;
		}
	}
	
	//delete
	public boolean deleteData(int id) {
		pdr.deleteById(id);
		return true;
	}
	
	//sort
	public List<PersonalDetails> sortData(String field) {
		return pdr.findAll(Sort.by(Sort.DEFAULT_DIRECTION, field));
	}
	
	//pagination
	public List<PersonalDetails> getPage(int pgNo,int pgSize) {
		Page<PersonalDetails> p = pdr.findAll(PageRequest.of(pgNo, pgSize));
		return p.getContent();
	}
	
	//select
	public List<PersonalDetails> selectByData(String field,String value) {
		return pdr.selectData(field, value);
	}
	
	//update
	public boolean updateValue(String changeField,String changeValue,String checkField,String checkValue) {
		try {
			pdr.updateData(changeField, changeValue, checkField, checkValue);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
