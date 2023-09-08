package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mapper.DeptMapper;
import com.example.mapper.EmpMapper;
import com.example.model.Emp;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/emp")
public class EmpController2 {
	@Autowired 
	EmpMapper empmapper;
	
	@Autowired
	DeptMapper deptmapper;
	
	@GetMapping("/list2")
	void selectAll(Integer d, String search, HttpServletRequest request) {
	
		System.out.println(d); //null로 들어옴. 
		System.out.println(search); // search는 string이어서 널스트링으로 값이 들어온다. 
		
		
	var depts = deptmapper.selectAll();
	request.setAttribute("depts", depts);
	
	List<Emp> list = null;
	
	if(d == null) {
	 list = empmapper.selectAll();
	}
	else {
	 list = empmapper.selectName(d);
	}
	request.setAttribute("list", list);
	 
	 //System.out.println(d);
	 //System.out.println(EmpController.class.getName()+"selectAll...");
		
	}
 // view를 리턴하지 않으면(void) 스프링이 알아서 요청한 루트를 뷰로 리턴한다.  	
}


//10	경리부
//20	인사부
//30	영업부
//40	전산부