package com.example.dao;

import org.springframework.stereotype.Repository;

@Repository
public class NewsDAO {

	public String selectNews() {
		System.out.println("Inside NewsDAO.selectNews()");
		//JDBC loc
		return "Funny Day";
	}

}
