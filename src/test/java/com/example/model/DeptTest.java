package com.example.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mapper.DeptMapper;


public class DeptTest {

	
	
	@Test
	void setter() {
		var dept = new Dept();
		dept.setDeptno(10);
		dept.setDname("총무부");
		dept.setLoc("부산");
		
		assertThat(dept.getDeptno()).isEqualTo(10);
		assertThat(dept.getDname()).isEqualTo("총무부");
		assertThat(dept.getLoc()).isEqualTo("부산");
	}
	
	@Test
	void equals() {
		var dept1 = new Dept();
		dept1.setDeptno(10);
		dept1.setDname("총무부");
		dept1.setLoc("부산");
		
		var dept2 = new Dept();
		dept2.setDeptno(10);
		dept2.setDname("총무부");
		dept2.setLoc("부산");
		
		//equals는 메모리주소와는 상관없다. 값에 기반한 비교
		System.out.println(dept1.equals(dept2));
		System.out.println(dept1);
		System.out.println(dept2);
		System.out.println(dept1==dept2);
		
		assertThat(dept1).isEqualTo(dept2);
	}
	
	@Test
	void hashcode() {
		var dept1 = new Dept();
		dept1.setDeptno(10);
		dept1.setDname("총무부");
		dept1.setLoc("부산");
		
		var dept2 = new Dept();
		dept2.setDeptno(10);
		dept2.setDname("총무부");
		dept2.setLoc("부산");
		
		//hashcode는 값이 같으면 같아야 한다. 인스턴스의 메모리주소와는 관계 없다.
		//(두 인스턴스는 개별적 객체임. 주소다름. 데이터만 같음.) 
		assertThat(dept1.hashCode()).isEqualTo(dept2.hashCode());
	}
	
	@Test
	void tostring() {
		var dept1 = new Dept();
		dept1.setDeptno(10);
		dept1.setDname("총무부");
		dept1.setLoc("부산");
		System.out.println(dept1);
		
		var dept2 = new Dept();
		dept2.setDeptno(10);
		dept2.setDname("총무부");
		dept2.setLoc("부산");
		
		assertThat(dept1.toString()).isEqualTo(dept2.toString());
		assertThat(dept1.toString()).isEqualTo("Dept(deptno=10, dname=총무부, loc=부산)");
	}
	
	@Test
	void biulder() {
		//요소 세팅 순서 상관없음
		var dept1 = new Dept();
		dept1.setDeptno(10);
		dept1.setDname("개발부");
		dept1.setLoc("서울");
		//요소 세팅 순서 상관있음(순서대로)
		var dept2 = new Dept(10,"개발부","서울");
		//요소 세팅 순서 상관없음
		var dept3 = Dept.builder().deptno(10).dname("개발부").loc("서울").build();
	
	 
		assertThat(dept1).isEqualTo(dept2);
		assertThat(dept1).isEqualTo(dept3);
		assertThat(dept2).isEqualTo(dept3);
	 
	}
	

}
