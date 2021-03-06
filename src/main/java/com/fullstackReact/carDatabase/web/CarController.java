package com.fullstackReact.carDatabase.web;

import com.fullstackReact.carDatabase.domain.Car;
import com.fullstackReact.carDatabase.domain.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    @Autowired
    private CarRepository repository;
    @RequestMapping(value = "/cars")
    public Iterable<Car> getCars() {
        return repository.findAll();
    };
}
