package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.PersonalDetails;

import jakarta.transaction.Transactional;

public interface PDRepo extends JpaRepository<PersonalDetails, Integer>{

	@Query(value = "SELECT * FROM Personal_Details where user_name = :value", nativeQuery = true)
	public List<PersonalDetails> selectData(@Param(value = "value") String value);

	@Modifying
	@Transactional
	@Query(value = "UPDATE Personal_Details SET phone_num = :changeValue WHERE name = :checkValue", nativeQuery = true)
	public Integer updateData(@Param("changeValue") long changeValue, @Param("checkValue") String checkValue );
//
//	@Modifying
//    @Transactional
//    @Query(value = "DELETE FROM Personal_Details WHERE name = :name")
//	public Integer deleteData(@Param("name") String name);
}
