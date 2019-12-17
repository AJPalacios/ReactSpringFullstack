package com.fullstackReact.carDatabase;

import com.fullstackReact.carDatabase.domain.Owner;
import com.fullstackReact.carDatabase.domain.OwnerRepository;
import org.aspectj.apache.bcel.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fullstackReact.carDatabase.domain.Car;
import com.fullstackReact.carDatabase.domain.CarRepository;

@SpringBootApplication
public class CarDatabaseApplication {
	private static final Logger logger = LoggerFactory.getLogger(CarDatabaseApplication.class);
	// Inject Repositories
	@Autowired
	private CarRepository repository;

	@Autowired
	private OwnerRepository orepository;

	public static void main(String[] args) {
		SpringApplication.run(CarDatabaseApplication.class, args);
		logger.info("Initialized");
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			// save demo data to database

			// Owner Objects and save to the db
			Owner owner1 = new Owner("John", "Johnson");
			Owner owner2 = new Owner("Mary", "Robinson");
			orepository.save(owner1);
			orepository.save(owner2);

			// Add Car Objects and save to the db
			repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1));
			repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2));
			repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2));
		};
	}

}
