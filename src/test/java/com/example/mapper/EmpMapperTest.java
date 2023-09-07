package com.example.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmpMapperTest {
	
	@Autowired
	EmpMapper mapper;

	@Test
	void selectAll() {
		
		var list = mapper.selectAll();
		
		System.out.println(list);
	}
	
	@Test
	void selectName() {
		var list = mapper.selectName("김");
		System.out.println(list);
		
		assertThat(list).isNotNull();
		assertThat(list).isNotEmpty();
	}
}
