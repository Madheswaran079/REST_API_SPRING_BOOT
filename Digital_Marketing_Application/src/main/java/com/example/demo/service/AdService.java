package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Advertisement;
import com.example.demo.repository.AdRepo;

@Service
public class AdService {
	
	@Autowired
	AdRepo adr;
	
	public Optional<Advertisement> getById(int id) {
		return adr.findById(id);
	}
	public List<Advertisement> getAll() {
		return adr.findAll();
	}
	
	public Advertisement postData(Advertisement pd) {
		return adr.save(pd);
	}
	public List<Advertisement> postAll(List<Advertisement> pd){
		return (List<Advertisement>)adr.saveAll(pd);
	}
	
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
	
	public boolean deleteData(int id) {
		adr.deleteById(id);
		return true;
	}

}
