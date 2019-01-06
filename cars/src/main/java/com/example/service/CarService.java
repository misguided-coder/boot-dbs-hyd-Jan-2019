package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CarDAO;
import com.example.model.Car;

@Service
public class CarService {

	@Autowired
	CarDAO carDAO;

	public Car readCarByVIN(int vin) {
		System.out.println("Inside CarService.readCarByVIN()!!!!!");
		return carDAO.findCarByVIN(vin);
	}
	
	
	public List<Car> readAllCars() {
		System.out.println("Inside CarService.readAllCars()!!!!!");
		return carDAO.selectAllCars();
	}
	

	public int addCar(Car car) {
		System.out.println("Inside CarService.addCar()!!!!!");
		return carDAO.saveCar(car);
	}
	

	public Car modifyCar(Car car) {
		System.out.println("Inside CarService.modifyCar()!!!!!");
		return carDAO.updateCar(car);
	}
	
	public int removeCar(int vin) {
		System.out.println("Inside CarService.removeCar()!!!!!");
		return carDAO.deleteCar(vin);
	}


}
