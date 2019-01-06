package com.example.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		
		//IoC Container is started
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/example/di/appCxt.xml");
			
		BookService bookService = applicationContext.getBean("bookService",BookService.class);
		
		//System.out.println(bookService.readAll());
		
		//IoC Container is stopped
		applicationContext.close();

	}
}
