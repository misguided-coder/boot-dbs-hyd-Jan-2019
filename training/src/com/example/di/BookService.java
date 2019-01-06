package com.example.di;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("bookService")
@Lazy
public class BookService {

	@Autowired
	BookDAO bookDAO;

	public BookService() {
		System.out.println("Inside BookService constructor()!!!!!!");
	}

	/*
	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}*/

	public List<Book> readAll() {
		return bookDAO.selectAll();
	}

}
