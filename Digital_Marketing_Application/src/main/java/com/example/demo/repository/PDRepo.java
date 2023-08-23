package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.PersonalDetails;

public interface PDRepo extends JpaRepository<PersonalDetails, Integer>{

}
