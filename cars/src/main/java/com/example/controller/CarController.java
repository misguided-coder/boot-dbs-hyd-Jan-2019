package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Car;
import com.example.service.CarService;

@RestController
@RequestMapping("/api")
public class CarController {
	
	@Autowired
	CarService carService;
	
	//http://localhost:8080/api/car (Resource URI)
	//@RequestMapping(value="/car",method=RequestMethod.GET,produces= {"application/json"})
	@GetMapping("/car")
	public Car readCar() {
		System.out.println("Inside CarsController.readCar()!!!!!");
		return new Car(100,"X1","BMW",4500000.00);
	}

	//Read a car
	@GetMapping("/car/vin")
	public Car getCar() {
		System.out.println("Inside CarsController.getCar()!!!!!");
		return carService.readCarByVIN(100);
	}

	//Read a car
	@GetMapping(value="/car/{id}",produces= {"application/json","application/xml"})
	public Car getCarByVin(@PathVariable("id") int vin) {
		System.out.println("Inside CarsController.getCar()!!!!!");
		return carService.readCarByVIN(vin);
	}

	
	//Read all car
	@GetMapping(value="/cars",produces= {"application/json","application/xml"})
	public List<Car> getAllCars() {
		System.out.println("Inside CarsController.getAllCars()!!!!!");
		return carService.readAllCars();
	}

	//Add new car
	@PostMapping(value="/car",consumes="application/json",produces="text/plain")
	public String addCar(@RequestBody Car car) {
		System.out.println("Inside CarsController.addCar()!!!!!");
		System.out.println("Car ========================= "+car);
		if(carService.addCar(car)> 0) {
			return "Car added successfully!!!!";
		}else {
			return "Could not save Car!!!!";
		}
	}

	//Update Car
	@PutMapping(value="/car/{vin}",consumes="application/json",produces="application/json")
	public Car modifyCar(@RequestBody Car car,@PathVariable int vin) {
		System.out.println("Inside CarsController.modifyCar()!!!!!");
		System.out.println("Car ========================= "+car);
		car.setVin(vin);
		return carService.modifyCar(car);
	}
	
	//Delete Car
	@DeleteMapping(value="/car/{vin}",produces="text/plain")
	public String removeCar(@PathVariable int vin) {
		System.out.println("Inside CarsController.removeCar()!!!!!");
		if(carService.removeCar(vin)> 0) {
			return "Car '"+vin+"' removed successfully!!!!";
		}else {
			return "Could not remove Car!!!!";
		}
	}
	
}
