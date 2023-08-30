package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.PersonalDetails;

import jakarta.transaction.Transactional;

public interface PDRepo extends JpaRepository<PersonalDetails, Integer>{

	@Query(value = "SELECT * FROM Personal_Details where :field = :value", nativeQuery = true)
	public List<PersonalDetails> selectData(@Param(value = "field") String field, @Param(value = "value") String value);

	@Modifying
	@Transactional
	@Query(value = "UPDATE Personal_Details SET :changeField = :changeValue WHERE :checkField = :checkValue", nativeQuery = true)
	public String updateData(@Param(value = "changeField") String changeField, @Param(value = "changeValue") String changeValue, @Param(value = "checkField") String checkField, @Param(value = "checkValue") String checkValue );
}
