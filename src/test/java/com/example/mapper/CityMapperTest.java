package com.example.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CityMapperTest {
	
	@Autowired
	CityMapper mapper;
	
	@Test
	void test1() {
		
		var list = mapper.selectAll();
		
		assertThat(list).isNotEmpty();
		assertThat(list).isNotNull();
		assertThat(list.size()).isGreaterThan(3000);
		
	}

}


//--1. 모두 조회 over3000
//select * from city; 
//
//--2. 조건조회(city만 조회) 276
//select * from city WHERE name LIKE '%A%'; 
//
//--3.조건조회(city를 조회하고 결과 안에서 구역을 재조회)16
//select * from city WHERE name LIKE '%K%' and district LIKE '%M%';