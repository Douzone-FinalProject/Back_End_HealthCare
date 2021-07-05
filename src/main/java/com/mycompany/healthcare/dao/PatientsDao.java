package com.mycompany.healthcare.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.healthcare.dto.Patients;
import com.mycompany.healthcare.dto.Staffs;

@Mapper
public interface PatientsDao {
	public List<Staffs> selectAllStaff();

	public int insertPatient(Patients patients);

	public List<Patients> selectSearchPatientIdList(String patient_id);
}
