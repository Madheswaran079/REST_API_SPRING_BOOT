package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Advertisement;
import com.example.demo.repository.AdRepo;

@Service
public class AdService {
	
	@Autowired
	AdRepo adr;
	
	//post
	public Advertisement postData(Advertisement pd) {
		return adr.save(pd);
	}
	public List<Advertisement> postAll(List<Advertisement> pd){
		return (List<Advertisement>)adr.saveAll(pd);
	}
	
	//get
	public Optional<Advertisement> getById(int id) {
		return adr.findById(id);
	}
	public List<Advertisement> getAll() {
		return adr.findAll();
	}
	
	//put
	public Advertisement putData(int id, Advertisement ad) {
		Advertisement exist = adr.findById(id).orElse(null);
		if(exist != null)
		{
			if(ad.getOrderId() != 0)
			{
				exist.setOrderId(ad.getOrderId());				
			}
			if(ad.getProduct() != null)
			{
				exist.setProduct(ad.getProduct());
			}
			if(ad.getRate() != 0)
			{
				exist.setRate(ad.getRate());				
			}
			if(ad.getOffer() != null)
			{
				exist.setOffer(ad.getOffer());				
			}
			if(ad.getDealDuration() != 0)
			{
				exist.setDealDuration(ad.getDealDuration());				
			}
			if(ad.getAdType() != null)
			{
				exist.setAdType(ad.getAdType());				
			}
			return adr.save(exist);
		}
		else {
			return null;
		}
	}
	
	//delete
	public boolean deleteData(int id) {
		adr.deleteById(id);
		return true;
	}
	
	//sort
	public List<Advertisement> sortData(String field) {
		return adr.findAll(Sort.by(Sort.DEFAULT_DIRECTION, field));
	}
	
	//pagination
	public List<Advertisement> getPage(int pgNo,int pgSize) {
		Page<Advertisement> p = adr.findAll(PageRequest.of(pgNo, pgSize));
		return p.getContent();
	}
	
	//select
	public List<Advertisement> selectByData(float value) {
		return adr.selectData(value);
	}
	
	//update
	public boolean updateValue(int changeValue, String checkValue) {
		try {
			adr.updateData(changeValue, checkValue);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
}
