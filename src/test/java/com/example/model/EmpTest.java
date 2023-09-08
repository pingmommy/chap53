package com.example.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class EmpTest {

	@Test
	void biulder() {
		var emp1 = new Emp(1000,"홍길동",null,null,null,null,null,0.0,null);
		
		var emp2 = Emp.builder().empno(1000).ename("홍길동").build();
		
		var emp3 = new Emp();
		emp3.setEmpno(1000);
		emp3.setEname("홍길동");
		
		
		System.out.println(emp1);
		System.out.println(emp2);
		System.out.println(emp3);
		
	   System.out.println(emp1.equals(emp2));
	   System.out.println(emp1.equals(emp3));
	   System.out.println(emp2.equals(emp3));
	   
	   assertThat(emp1).isEqualTo(emp2);
	   assertThat(emp1).isEqualTo(emp3);
	   assertThat(emp2).isEqualTo(emp3);
	}
}
