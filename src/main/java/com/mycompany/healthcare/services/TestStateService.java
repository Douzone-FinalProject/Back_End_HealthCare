package com.mycompany.healthcare.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.healthcare.dao.DiagnosticListsDao;
import com.mycompany.healthcare.dao.ReceiptAndOpinionsDao;
import com.mycompany.healthcare.dao.StaffsDao;
import com.mycompany.healthcare.dto.DiagnosticLists;
import com.mycompany.healthcare.dto.ReceiptAndOpinions;
import com.mycompany.healthcare.dto.StateCharts;
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
			String hospital_id = Integer.toString(staffsDao.getHospitalIdByLoginId(updateData.get("staff_login_id").toString()));
			DateFormat format = new SimpleDateFormat("yyyyMMdd");
			String dateStr = format.format(new Date());
			List<String> diagnosticListIds = new ArrayList<String>();
			diagnosticListIds = (List<String>) updateData.get("rowKeys");
			List<String> specimens = (List<String>) updateData.get("bundleSpecimens");
			ArrayList<Map<String, String>> specimenNums = new ArrayList<Map<String, String>>();
			for (int i = 0; i < specimens.size(); i++) {
				if (specimens.get(i) != "") {
					Map<String, String> map = new HashMap<String, String>();
					map.put("rowkey", String.valueOf(diagnosticListIds.get(i)));
					map.put("num", dateStr + hospital_id + String.valueOf(diagnosticListIds.get(i)));
					specimenNums.add(map);
				} else {
					Map<String, String> map = new HashMap<String, String>();
					map.put("rowkey", String.valueOf(diagnosticListIds.get(i)));
					map.put("num", "");
					specimenNums.add(map);
				}
			}
			updateData.put("specimenNums", specimenNums);
		}
		
		diagnosticListsDao.updateStateDetail(updateData);
		
	}

	public List<StateCharts> getStateChart() {
		return receiptAndOpinionsDao.selectStateChart();
	}

	public void updatePatientState(Map<String, Object> updateData) {
		receiptAndOpinionsDao.updatePatientState(String.valueOf(updateData.get("receiptId")));
	}

	public void updateReceiptStates(Map<String, String> updateData) {
		receiptAndOpinionsDao.updateReceiptStates(updateData);
	}
}
