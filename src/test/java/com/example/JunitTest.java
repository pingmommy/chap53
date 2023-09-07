package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class JunitTest {
	

	@Test
	void test1() {
		System.out.println("test1..");
		
	}
	
	@Test
	void test2() {
		System.out.println("test2..");
		
		int num =100;
		assertThat(num).isEqualTo(200);
	}
	
	@Test
	void test3() {
		int sum =0;
		for(int i=1;i<10;i++) {
			sum += i;
		}
		
		assertThat(sum).isEqualTo(45);
	}
	
}


//junit 단위 테스트하는 라이브러리 

//테스트는 왜 하나 - 오류검증
//
//테스트는 어떻게 사용하나 - test 폴더에 junitTest 클래스를 만들고 @Test 어노테이션을 준다. 
