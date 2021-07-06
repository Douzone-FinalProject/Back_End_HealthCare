package com.mycompany.healthcare.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.healthcare.dao.DiagnosticListsDao;
import com.mycompany.healthcare.dao.ReceiptAndOpinionsDao;
import com.mycompany.healthcare.dao.StaffsDao;
import com.mycompany.healthcare.dto.DiagnosticLists;
import com.mycompany.healthcare.dto.ReceiptAndOpinions;
import com.mycompany.healthcare.dto.TestStateDetail;

@Service
public class TestStateService {
	
	@Autowired
	private ReceiptAndOpinionsDao receiptAndOpinionsDao;
	
	@Autowired
	private DiagnosticListsDao diagnosticListsDao;
	
	@Autowired
	private StaffsDao staffsDao;
	
	public List<ReceiptAndOpinions> getPatientStateList(String type, String state) {
		return receiptAndOpinionsDao.selectPatientStateList(type, state);
	}

	public List<TestStateDetail> getTestStateDetailList(int receiptId) {
		List<TestStateDetail> d = diagnosticListsDao.selectTestStateDetailLIst(receiptId);
		System.out.println(d.get(0));
		return diagnosticListsDao.selectTestStateDetailLIst(receiptId);
	}

	public void updateStateDetail(Map<String, Object> updateData) {
		if (updateData.get("state").equals("검사완료")) {
			int hospital_id = staffsDao.getHospitalIdByLoginId(updateData.get("staff_login_id").toString());
			System.out.println(hospital_id);
			DateFormat date = new SimpleDateFormat("yyyyMMdd");
		}
		
//		diagnosticListsDao.updateStateDetail(updateData);
		
	}
}
