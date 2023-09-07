package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping("/hello")
	String hello() {
		return"hello";
	}
}

//*********MVC패턴
//M - model
//
//V - view  (jsp) - 컨트롤러한테 받은 데이터를 html로 맵핑해서 view만 한다. 
//
//C - controller - 1 .웹의 요청을 받음 패턴의 전면에 있다. 2.데이터를 만들어낸다.
//
//WEB-INF 안에 파일은 컨트롤러만 호출할 수 있다. 웹에서 직접 호출할 수 없음.  
