package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import com.example.mapper.EmpMapper.SqlProvider;
import com.example.model.City;

@Mapper
public interface CityMapper {
	
	@Select("select * from city order by id")
	List<City> selectAll(); 
	
	@SelectProvider(type = SqlProvider.class, method = "selectCity")
	List<City> selectCity(String cityname, String district);
	
	public static class SqlProvider {
		
		public static String selectCity(String cityname, String district) {
			
			var s = new SQL();
			s.SELECT("*");
			s.FROM("city");
			
			if(cityname != null) {
				s.WHERE(String.format("name like '%%%s%%'", cityname));
			}
			if(district !=null && !district.trim().equals("")) {
				s.AND();
				s.WHERE(String.format("district like '%%%s%%'", district));
			}
			return s.toString();
		}
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