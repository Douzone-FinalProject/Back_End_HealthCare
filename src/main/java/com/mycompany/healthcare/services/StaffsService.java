package com.mycompany.healthcare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mycompany.healthcare.dao.DiagnosticListsDao;
import com.mycompany.healthcare.dao.MedicinePresDao;
import com.mycompany.healthcare.dao.PatientsDao;
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
	
	@Autowired
	private PatientsDao patientsDao;
	
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

	public int getACount() {
		int acount = patientsDao.selectACount();
		return acount;
	}

	public int getBCount() {
		int bcount = patientsDao.selectBCount();
		return bcount;
	}

	public int getABCount() {
		int abcount = patientsDao.selectABCount();
		return abcount;
	}

	public int getOCount() {
		int ocount = patientsDao.selectOCount();
		return ocount;
	}

	public int getRH_ACount() {
		int rh_acount = patientsDao.selectRH_ACount();
		return rh_acount;
	}

	public int getRH_BCount() {
		int rh_bcount = patientsDao.selectRH_BCount();
		return rh_bcount;
	}

	public int getRH_ABCount() {
		int rh_abcount = patientsDao.selectRH_ABCount();
		return rh_abcount;
	}

	public int getRH_OCount() {
		int rh_ocount = patientsDao.selectRH_OCount();
		return rh_ocount;
	}

	public int getStaffCount() {
		int staffcount = staffsDao.selectStaffCount();
		return staffcount;
	}

	public int getDisableStaffCount() {
		int disablestaffcount = staffsDao.selectDisableStaffCount();
		return disablestaffcount;
	}
}
