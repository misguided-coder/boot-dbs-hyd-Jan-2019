package com.example.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		
		//IoC Container is started
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/example/service/appCxt.xml");
		System.out.println("Container is started!!!!");
			
		
		//CalculatorService calculatorService = new CalculatorService();
		
		//Client 1
		CalculatorService calculatorService1 = (CalculatorService) applicationContext.getBean("calculatorService");
		
		System.out.println(calculatorService1);
		System.out.println(calculatorService1.doSum(10, 2));
		System.out.println(calculatorService1.doDiff(10, 2));
		
		//Client 2
		CalculatorService calculatorService2 = (CalculatorService) applicationContext.getBean("calculatorService");
		
		System.out.println(calculatorService2);
		System.out.println(calculatorService2.doSum(10, 2));
		System.out.println(calculatorService2.doDiff(10, 2));
		
		//IoC Container is stopped
		applicationContext.close();
		System.out.println("Container is shut down!!!!");
		
		
	
		
	}
}
