package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.util.Alpha;
import com.example.util.Color;

import jakarta.servlet.http.HttpServletRequest;



@Controller
public class AlphaController {

	@GetMapping("/alpha")
	String alpha(HttpServletRequest request) {
		
		Alpha[][] alphas = new Alpha[20][40];
		
		for(int i =0; i<20; i++) {
			for(int j=0; j<40; j++) {
				alphas[i][j] = new Alpha();
			}
			
		}
		
		request.setAttribute("alphas", alphas);
		return "alpha";
	}
	
	@GetMapping("/alpha2")
	String alpha2(Integer line, Integer column, Character ch, Color fg, Color bg, HttpServletRequest request) {
		
		System.out.printf("%s %s %s",line, column,ch);
		Alpha[][] alphas = new Alpha[20][40];
		
		for(int i =0; i<20; i++) {
			for(int j=0; j<40; j++) {
				alphas[i][j] = new Alpha();
				alphas[i][j].setFg(Color.Black);
				alphas[i][j].setBg(Color.Black);
			}
		}
		
		if(line != null && column !=null && ch != null ) {
			 var alpha = new Alpha();
			
			alpha.setCh(ch);
			alpha.setLine(line);
			alpha.setColumn(column);
			alpha.setBg(bg);
			alpha.setFg(fg);
			alphas[line-1][column-1]=alpha;
		}
		
		
		
		request.setAttribute("alphas", alphas);
		
		String[] chs = new String[26];
		
		for(int i =0; i<26; i++) {
			chs[i] = (char)('A'+i)+"";
		}
		
		request.setAttribute("chs", chs);
		
		request.setAttribute("colors", Color.values());
 		
	 return"alpha2";
	}
}
