package com.example.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.isNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DeptMapperTest {

	@Autowired
	DeptMapper mapper;
	
	@Test
	void autowired() {
		assertThat(mapper).isNotNull();
	}
	
	
	@Test
	void selectAll() {
		var list = mapper.selectAll();
		System.out.println(list);
		
		assertThat(list).isNotNull();
		assertThat(list).isNotEmpty();
		assertThat(list.size()).isGreaterThan(0);
	}
	
	@Test
	void selectByDname() {
		var list = mapper.selectByDname(null);
		assertThat(list).isNotNull();
		assertThat(list.size()).isGreaterThan(0);
		
		list = mapper.selectByDname("");
		assertThat(list).isNotNull();
		assertThat(list.size()).isGreaterThan(0);
		
		list = mapper.selectByDname("부");
		assertThat(list.size()).isEqualTo(4);
	}
}


/*스프링이 동작하면서 스프링팩토리의 빈에 인터페이스 구현클래스(인스턴스)를 저장해놓는다. 
  이를 Autowired를 통해서 맵핑한다.
  
  스프링팩토리에서 구현클래스를 불러 오면 타입지정해서 변수선언하고 Autowired 어노테이션을 붙이주면 된다.  
 
  스프링 - 자바프레임워크 마이바티스 - db연동할 때 쓰는 프레임워크(sql문) 
  
  */
 