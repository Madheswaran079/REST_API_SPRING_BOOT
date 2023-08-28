package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Car;

public interface CarRepo extends JpaRepository<Car, Integer>{

	@Query(value = "SELECT * FROM Car WHERE owners = :o" , nativeQuery = true)
	public List<Car> findByOwners(@Param(value = "o")int o);
	
	@Query(value = "SELECT * FROM Car WHERE address = :a" , nativeQuery = true)
	public List<Car> findByAddress(@Param(value = "a")String a);
	
	@Query(value = "SELECT * FROM Car WHERE car_name = :c" , nativeQuery = true)
	public List<Car> findByCarName(@Param(value = "c")String c);

	@Query(value = "SELECT * FROM Car WHERE owners = :o AND car_type = :ct" , nativeQuery = true)
	public List<Car> findByOwnersAndCarType(@Param(value = "o")int o, @Param(value = "ct")String ct);
}
