package com.mycompany.healthcare.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.healthcare.dto.Staffs;

@Mapper
public interface DiagnosticResultsDao {
	public List<Staffs> selectAllStaff();
}
