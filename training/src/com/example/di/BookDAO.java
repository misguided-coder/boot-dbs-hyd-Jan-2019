package com.example.di;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BookDAO {

	public BookDAO() {
		System.out.println("Inside BookDAO constructor()!!!!!!");
	}

	public List<Book> selectAll() {
		// TBD JDBC LOC
		List<Book> books = new ArrayList<>();
		books.add(new Book("8712901222", "Hibernate In Action"));
		books.add(new Book("8712901223", "DOJO In Action"));
		return books;
	}

}
