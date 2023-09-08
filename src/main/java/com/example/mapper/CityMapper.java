package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.model.City;

@Mapper
public interface CityMapper {
	
	@Select("select * from city")
	List<City> selectAll(); 

}


//--1. 모두 조회 over3000
//select * from city; 
//
//--2. 조건조회(city만 조회) 276
//select * from city WHERE name LIKE '%A%'; 
//
//--3.조건조회(city를 조회하고 결과 안에서 구역을 재조회)16
//select * from city WHERE name LIKE '%K%' and district LIKE '%M%';