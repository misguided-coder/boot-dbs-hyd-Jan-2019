package com.example.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.model.Car;

public class CarRowMapper implements RowMapper<Car> {

	@Override
	public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
		Car car = new Car();
		car.setVin(rs.getInt(1));
		car.setModel(rs.getString(2));
		car.setMake(rs.getString(3));
		car.setPrice(rs.getDouble(4));
		return car;
	}

}
