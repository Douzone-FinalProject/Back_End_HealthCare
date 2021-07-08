package com.mycompany.healthcare.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HospitalsDao {
	public String selectHospitalName(int hospital_id);
}
