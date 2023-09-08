package com.example.model;

import org.junit.jupiter.api.Test;

public class CityTest {
	
	@Test
	void test1() {
		var city1 = new City();
		city1.setName("ara");
		city1.setDistrict("cho");
		
		System.out.println(city1);
		
		var city2 = City.builder().name("ping").country_code("6").build();
		System.out.println(city2);
	}

}
