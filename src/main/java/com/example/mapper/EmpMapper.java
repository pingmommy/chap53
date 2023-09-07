package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.model.Emp;

@Mapper
public interface EmpMapper {
	
	@Select("select * from Emp")
	List<Emp> selectAll();
	
	@Select("""
			select *
			  from emp
			 where ename like '%${search}%' 
		""")
	List<Emp> selectName(String search);

}
