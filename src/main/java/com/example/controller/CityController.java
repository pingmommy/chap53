package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mapper.CityMapper;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/city")
public class CityController {
	
	@Autowired
	CityMapper citymapper;
	
	@GetMapping("/list")
	String selectall(HttpServletRequest request) {
		
		var list = citymapper.selectAll();
		
		request.setAttribute("list", list);
		return"city/list";
	}
}
