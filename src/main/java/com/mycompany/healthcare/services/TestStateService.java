package com.mycompany.healthcare.services;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.healthcare.dao.DiagnosticImgsDao;
import com.mycompany.healthcare.dao.DiagnosticListsDao;
import com.mycompany.healthcare.dao.PatientsDao;
import com.mycompany.healthcare.dao.ReceiptAndOpinionsDao;
import com.mycompany.healthcare.dao.StaffsDao;
import com.mycompany.healthcare.dto.DiagnosticImgs;
import com.mycompany.healthcare.dto.DiagnosticLists;
import com.mycompany.healthcare.dto.LabCharts;
import com.mycompany.healthcare.dto.ReceiptAndOpinions;
import com.mycompany.healthcare.dto.SaveImgs;
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
	
	@Autowired
	private DiagnosticImgsDao diagnosticImgsDao;
	
	@Autowired
	private PatientsDao patientsDao;
	
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

	public void uploadImg(SaveImgs saveImgs) {
		// base64에 붙어있는 파일 정보들을 떼어서 저장하기 위해
		String[] base64Str = saveImgs.getBase64().split(",");
		
		// base64로 인코딩되어 있는 데이터를 디코딩하여 byte[]로 받음
//		byte[] decodeBytes = Base64.getDecoder().decode(base64Str[1]);
		
//		String defaultPath = System.getProperty("user.home") + "/images/";
		
		try {
			// 지정된 경로에 byte 배열로 받은 이미지를 만들어준다
//			String time = ""+new Date().getTime();
//			FileUtils.writeByteArrayToFile(new File(defaultPath + time + saveImgs.getFilename() + ".jpeg"), decodeBytes);
			
			// 이미지의 정보를 보내기 위해 DTO에 정보를 넣어준다
			DiagnosticImgs diagnosticImgs = new DiagnosticImgs();
			diagnosticImgs.setDiagnostic_img(saveImgs.getBase64());
			diagnosticImgs.setImg_type("image/jpeg");
			diagnosticImgs.setReceipt_id(saveImgs.getReceiptId());
			
			// 테이블의 정보를 삽입
			diagnosticImgsDao.insertDiagnosticImg(diagnosticImgs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		saveImgs.setBase64("");
	}

	public String getPatientName(int receiptId) {
		return patientsDao.selectPatientNameByReceiptId(receiptId);
	}

	public List<LabCharts> getLabChart() {
		return diagnosticListsDao.countLabPatient();
	}
}
