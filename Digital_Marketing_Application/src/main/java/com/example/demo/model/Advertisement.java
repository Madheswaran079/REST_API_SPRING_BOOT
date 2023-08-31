package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Advertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private String product;
	private float rate;
	private String offer;
	private int dealDuration;
	private String adType;
	public Advertisement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Advertisement(int orderId, String product, float rate, String offer, int dealDuration, String adType) {
		super();
		this.orderId = orderId;
		this.product = product;
		this.rate = rate;
		this.offer = offer;
		this.dealDuration = dealDuration;
		this.adType = adType;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public String getOffer() {
		return offer;
	}
	public void setOffer(String offer) {
		this.offer = offer;
	}
	public int getDealDuration() {
		return dealDuration;
	}
	public void setDealDuration(int dealDuration) {
		this.dealDuration = dealDuration;
	}
	public String getAdType() {
		return adType;
	}
	public void setAdType(String adType) {
		this.adType = adType;
	}
}
