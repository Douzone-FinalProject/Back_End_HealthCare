package com.mycompany.healthcare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.healthcare.dao.StaffsDao;
import com.mycompany.healthcare.dto.Staffs;

@Service
public class StaffsService {
	
	@Autowired
	private StaffsDao staffsDao;
	
	public List<Staffs> getStaffList() {
		return staffsDao.selectAllStaff();
	}
}
