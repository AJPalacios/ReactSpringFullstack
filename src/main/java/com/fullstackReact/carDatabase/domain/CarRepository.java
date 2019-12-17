package com.fullstackReact.carDatabase.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository <Car, Long> {
	// Fetch cars by brand using SQL
	@Query("select c from Car c where c.brand like %?1")
	List<Car> findByBrandEndsWith(String brand);
	// Fetch Cars By Color
	List<Car> findByColor(String color);
	// Fetch Cars By Year
	List<Car> findByYear(int year);
	// Fetch Cars By Brand And Model
	List<Car> findByBrandAndModel(String brand, String model);
	// Fetch Cars by Brand Or Color
	List<Car> findByBrandOrColor(String brand, String color);
	// Fetch cars by brand and sort by year
	List<Car> findByBrandOrderByYearAsc(String brand);
}
