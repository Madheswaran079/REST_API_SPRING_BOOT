package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Advertisement;

import jakarta.transaction.Transactional;

public interface AdRepo extends JpaRepository<Advertisement, Integer>{

	@Query(value = "SELECT * FROM Advertisement where rate > :value", nativeQuery = true)
	public List<Advertisement> selectData(@Param(value = "value") float value);

	@Modifying
	@Transactional
	@Query(value = "UPDATE Advertisement SET deal_duration = :changeValue WHERE product = :checkValue", nativeQuery = true)
	public Integer updateData(@Param("changeValue") int changeValue, @Param("checkValue") String checkValue );

}