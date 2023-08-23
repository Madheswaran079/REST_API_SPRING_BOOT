package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.PersonalDetails;
import com.example.demo.repository.PDRepo;

@Service
public class PDService {

	@Autowired
	PDRepo pdr;
	
	public Optional<PersonalDetails> getById(int id) {
		return pdr.findById(id);
	}
	public List<PersonalDetails> getAll() {
		return pdr.findAll();
	}
	
	public PersonalDetails postData(PersonalDetails pd) {
		return pdr.save(pd);
	}
	public List<PersonalDetails> postAll(List<PersonalDetails> pd){
		return (List<PersonalDetails>)pdr.saveAll(pd);
	}
	
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
	
	public boolean deleteData(int id) {
		pdr.deleteById(id);
		return true;
	}
}
