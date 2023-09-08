package com.example.dynamic;

import org.apache.ibatis.jdbc.SQL;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Trim;

public class SqlTest {
	
	@Test  //조건처리가 필요하면 test1의 방법
	void test1() {
		var s = new SQL();
		
		s.SELECT("*");
		s.FROM("emp");
		
		System.out.println(s.toString());
   }
	
	@Test
	void test2() {
		var s = new SQL().SELECT("*").FROM("emp");
		
		System.out.println(s);
	}
	
	@Test
	void test3() {
		//전체조회
		Integer d = null;
		String search = null;
	
		 System.out.println("1.전체");
		 System.out.println(dynamicSQL(null, ""));
		 System.out.println("2.all and search");
		 System.out.println(dynamicSQL(null, "과"));
		 System.out.println("3.부서");
		  System.out.println(dynamicSQL(10, ""));
		 System.out.println("4 부서 and search");
		 System.out.println(dynamicSQL(20, "사"));
	}
	
	
	String dynamicSQL(Integer d, String search) {
		
		var s = new SQL();
		s.SELECT("*")
		 .FROM("emp");
		
		if(d != null) {
			s.WHERE(String.format("d=%d", d));
		}
		if(!search.trim().equals("")) {
		s.AND();
		s.WHERE(String.format("ename like'%%%s%%' or job like'%%%s%%'",search, search));
		}
		
		

		return s.toString();
	}

}