package com.example.service;

public class CalculatorService {

	public CalculatorService() {
		System.out.println("Inside CalculatorService constructor()!!!!!!");
	}
	
	public int doSum(int valOne, int valTwo) {
		return valOne + valTwo;
	}

	public int doDiff(int valOne, int valTwo) {
		return valOne - valTwo;
	}
}
