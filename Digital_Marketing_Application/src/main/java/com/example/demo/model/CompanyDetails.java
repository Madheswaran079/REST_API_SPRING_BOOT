package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class CompanyDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String domain;
	private String companyName;
	private String companyEmail;
	private LocalDate startDate;
	private float revenue;
	private int branch;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId")
	private List<Advertisement> ad;
	
	public List<Advertisement> getAd() {
		return ad;
	}
	public void setAd(List<Advertisement> ad) {
		this.ad = ad;
	}
	
	public CompanyDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompanyDetails(int customerId, String domain, String companyName, String companyEmail,
			LocalDate startDate, float revenue, int branch, List<Advertisement> ad) {
		super();
		this.customerId = customerId;
		this.domain = domain;
		this.companyName = companyName;
		this.companyEmail = companyEmail;
		this.startDate = startDate;
		this.revenue = revenue;
		this.branch = branch;
		this.ad = ad;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public float getRevenue() {
		return revenue;
	}
	public void setRevenue(float revenue) {
		this.revenue = revenue;
	}
	public int getBranch() {
		return branch;
	}
	public void setBranch(int branch) {
		this.branch = branch;
	}
}
