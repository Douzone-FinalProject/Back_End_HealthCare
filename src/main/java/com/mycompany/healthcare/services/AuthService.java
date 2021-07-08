package com.mycompany.healthcare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.healthcare.dao.HospitalsDao;
import com.mycompany.healthcare.dao.StaffsDao;
import com.mycompany.healthcare.dto.Staffs;

@Service
public class AuthService {
	
	@Autowired
	private StaffsDao staffsDao;
	
	@Autowired
	private HospitalsDao hospitalsDao;
	
	public int compareHospitalCode(String staff_login_id, int hospital_id) {
		return staffsDao.compareHospitalId(staff_login_id, hospital_id);
	}

	public int compareRole(String staff_login_id, String staff_role) {
		return staffsDao.compareRole(staff_login_id, staff_role);
	}

	public String getStaffName(String staff_login_id) {
		return staffsDao.selectStaffName(staff_login_id);
	}

	public String getStaffRole(String staff_login_id) {
		return staffsDao.selectStaffRole(staff_login_id);
	}

	public String getHosiptalName(int hospital_id) {
		return hospitalsDao.selectHospitalName(hospital_id);
	}
}
