package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Bike;

public interface BikeRepo extends JpaRepository<Bike, Integer> {

	@Query(value = "SELECT * FROM Bike WHERE bike_name LIKE %:bn%", nativeQuery = true)
	public Optional<Bike> findByBikeName(@Param(value = "bn") String bn);
	
	@Query(value = "SELECT * FROM Bike WHERE year = :y", nativeQuery = true)
	public List<Bike> findByYear(@Param(value = "y") int y);

	@Query(value = "SELECT * FROM Bike WHERE year = :y OR bike_name LIKE %:bn%", nativeQuery = true)
	public List<Bike> findByYearOrBikeName(@Param(value = "y") int y, @Param(value = "bn") String bn);
}