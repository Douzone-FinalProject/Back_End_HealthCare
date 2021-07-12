package com.mycompany.healthcare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mycompany.healthcare.dao.DiagnosticListsDao;
import com.mycompany.healthcare.dao.MedicinePresDao;
import com.mycompany.healthcare.dao.ReceiptAndOpinionsDao;
import com.mycompany.healthcare.dao.StaffsDao;
import com.mycompany.healthcare.dto.Staffs;

@Service
public class StaffsService {
	
	@Autowired
	private StaffsDao staffsDao;
	
	@Autowired
	private ReceiptAndOpinionsDao receiptAndOpinionsDao;
	
	@Autowired
	private DiagnosticListsDao diagnosticListsDao;
	
	@Autowired
	private MedicinePresDao medicinePresDao;
	
	public List<Staffs> getStaffList(int hospital_id) {
		return staffsDao.selectAllStaff(hospital_id);
	}

	public void addStaff(Staffs employee) {
		staffsDao.insertStaff(employee);
		
	}

	public Staffs getStaff(int staff_id) {
		return staffsDao.selectStaff(staff_id);
	}

	public void deleteStaff(int staff_id) {
		staffsDao.deletetStaff(staff_id);
		
	}

	public int getReceiptCount() {
		int receiptCounts = receiptAndOpinionsDao.selectReceiptCount();
		return receiptCounts;
	}

	public int getTestCount() {
		int testCounts = diagnosticListsDao.selectTestCount();
		return testCounts;
	}

	public int getMedicinePresCount() {
		int medicinePresCounts = medicinePresDao.selectMedicinePresCount();
		return medicinePresCounts;
	}

	public void updateStaffNoPassword(Staffs nowStaff) {
		staffsDao.updateStaffNoPassword(nowStaff);
		
	}

	public void updateStaff(Staffs nowStaff) {
		BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
		nowStaff.setStaff_login_pwd(bpe.encode(nowStaff.getStaff_login_pwd()));
		staffsDao.updateStaff(nowStaff);
		
	}
}
