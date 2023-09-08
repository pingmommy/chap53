package com.example.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class EmpMapperTest {
	
	@Autowired
	EmpMapper mapper;

	
	@Autowired
   ApplicationContext factory; // 스프링이 Autowired를 통해 빈을 맵핑하는 작업을 수동으로 해봄.
	
	@Test
	void autowire() {
		assertThat(factory).isNotNull();
		var mapper = factory.getBean(EmpMapper.class);
		assertThat(mapper).isNotNull();
		
		System.out.println();
		
		System.out.println(this.mapper ==mapper);  //true
		System.out.println(this.mapper.equals(mapper)); //false 
		System.out.println(this.mapper.equals(this.mapper)); //false
		//참조는 같지만 conection이 달라서 안의 정보가 다르기 때문에 2,3번 문장은 false로 나온다.
		//인터페이스의 구현객체에 connection필드가 있다. 
		
		assertThat(this.mapper).isEqualTo(mapper);
		assertThat(this.mapper == mapper).isTrue();
	}
	
	@Test
	void selectAll() {
		
		var list = this.mapper.selectAll();
		var mapper = factory.getBean(EmpMapper.class);
		var list2 = mapper.selectAll();
		
		System.out.println(list);
		System.out.println(this.mapper == mapper);
		System.out.println(this.mapper.equals(mapper));
		System.out.println(this.mapper.equals(this.mapper));
		System.out.println(list.equals(list2));
	}
	
	@Test
	void selectName() {
		var list = mapper.selectName(10);
		System.out.println(list);
		
		
		assertThat(list).isNotNull();
		assertThat(list).isNotEmpty();
		
		assertThat(list.size()).isEqualTo(3);
	}
	
	@Test
	void selectBySearch() {
		var list =  mapper.selectBySearch(null, "");
		assertThat(list.size()).isEqualTo(14);
		
		list =  mapper.selectBySearch(null, "사");
	    System.out.println(list);
		assertThat(list.size()).isEqualTo(5);
//		
		list =  mapper.selectBySearch(20, "");
	    System.out.println(list);
		assertThat(list.size()).isEqualTo(5);
//		
		list =  mapper.selectBySearch(20, "사");
	    System.out.println(list);
		assertThat(list.size()).isEqualTo(5);
	}
}
