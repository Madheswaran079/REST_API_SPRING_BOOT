package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.CompanyDetails;

import jakarta.transaction.Transactional;

public interface CDRepo extends JpaRepository<CompanyDetails, Integer>{

	@Query(value = "SELECT * FROM Company_Details where branch = :value", nativeQuery = true)
	public List<CompanyDetails> selectData(@Param(value = "value") int value);

	@Modifying
	@Transactional
	@Query(value = "UPDATE Company_Details SET revenue = :changeValue WHERE company_name = :checkValue", nativeQuery = true)
	public Integer updateData(@Param("changeValue") float changeValue, @Param("checkValue") String checkValue );

}
