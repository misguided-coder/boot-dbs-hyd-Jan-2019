package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Car;
import com.example.util.CarRowMapper;

@Repository
public class CarDAO {
	
	@Autowired
	JdbcTemplate  jdbcTemplate;
	
	public Car findCarByVIN(int vin) {
		System.out.println("Inside CarsDAO.findCarByVIN()!!!!!");
		Object parms[] = {vin};
		return jdbcTemplate.queryForObject("select * from car_detail where vin=?",parms,new CarRowMapper());
	}
	

	public List<Car> selectAllCars() {
		System.out.println("Inside CarsDAO.selectAllCars()!!!!!");
		return jdbcTemplate.query("select * from car_detail",new CarRowMapper());
	}
	
	public int saveCar(Car car) {
		System.out.println("Inside CarsDAO.saveCar()!!!!!");
		Object parms[] = {car.getModel(),car.getMake(),car.getPrice()};
		return jdbcTemplate.update("insert into car_detail(model,make,price) values(?,?,?)",parms);
	}
	
	public Car updateCar(Car car) {
		System.out.println("Inside CarsDAO.updateCar()!!!!!");
		Object parms[] = {car.getModel(),car.getMake(),car.getPrice(),car.getVin()};
		jdbcTemplate.update("update car_detail set model=?,make=?,price=? where vin=?",parms);
		Object qparms[] = {car.getVin()};
		return jdbcTemplate.queryForObject("select * from car_detail where vin=?",qparms,new CarRowMapper());
	}
	
	public int deleteCar(int vin) {
		System.out.println("Inside CarsDAO.deleteCar()!!!!!");
		Object parms[] = {vin};
		return jdbcTemplate.update("delete from car_detail where vin=?",parms);
	}
	
	
}
