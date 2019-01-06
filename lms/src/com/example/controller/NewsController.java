package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.service.NewsService;

@Controller
public class NewsController {
	
	@Autowired
	NewsService newsService; 

	@RequestMapping(value="/news",method=RequestMethod.GET)
	public ModelAndView handleRequest() {
		System.out.println("Inside NewsController.handleRequest()");
		
		return new ModelAndView("news","BREAKING-NEWS",newsService.readNews());
	}
	
}
