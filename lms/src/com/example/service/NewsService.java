package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.NewsDAO;

@Service
public class NewsService {
	
	@Autowired
	NewsDAO newsDAO;

	public String readNews() {
		System.out.println("Inside NewsService.readNews()");
		return newsDAO.selectNews();
	}

}
