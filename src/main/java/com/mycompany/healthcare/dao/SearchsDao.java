package com.mycompany.healthcare.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.healthcare.dto.Searchs;
import com.mycompany.healthcare.dto.Staffs;

@Mapper
public interface SearchsDao {
	public List<Staffs> selectAllStaff();

	public List<Searchs> selectSearchList(String symptom_name);

}
