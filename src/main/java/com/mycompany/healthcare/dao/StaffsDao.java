package com.mycompany.healthcare.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycompany.healthcare.dto.Staffs;

@Mapper
public interface StaffsDao {
	public List<Staffs> selectAllStaff();
	public int compareHospitalId(@Param("staff_login_id") String staff_login_id, @Param("hospital_id") int hospital_id);
	public int compareRole(@Param("staff_login_id") String staff_login_id, @Param("staff_role") String staff_role);
	public int getHospitalIdByLoginId(String staff_login_id);
	public List<Staffs> getStaffListByHospitalId(int hospital_id);
	public String selectStaffName(String staff_login_id);
	public String selectStaffRole(String staff_login_id);
	
}
