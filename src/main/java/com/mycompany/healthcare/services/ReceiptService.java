package com.mycompany.healthcare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.healthcare.dao.PatientsDao;
import com.mycompany.healthcare.dao.ReceiptAndOpinionsDao;
import com.mycompany.healthcare.dto.Patients;
import com.mycompany.healthcare.dto.ReceiptAndOpinions;


@Service
public class ReceiptService {
	
	@Autowired
	private PatientsDao patientsDao;
	
	@Autowired
	private ReceiptAndOpinionsDao receiptDao;
	
	public List<Patients> getPatientList() {
		List<Patients> patientList = patientsDao.selectAllPatient();
		// 최초 진료 기록, 최근 진료 기록 setter 
		for(int i=0; i<patientList.size(); i++) {
			String firstReceiptDate = patientsDao.selectFirstReceiptDate(patientList.get(i).getPatient_id());
			String lastReceiptDate =  patientsDao.selectLastReceiptDate(patientList.get(i).getPatient_id());
			if(firstReceiptDate == null || lastReceiptDate == null) {
				firstReceiptDate = "진료 기록 없음";
				lastReceiptDate = "진료 기록 없음";
			}
			patientList.get(i).setFirstReceiptDate(firstReceiptDate);
			patientList.get(i).setLastReceiptDate(lastReceiptDate);
		}						
		return patientList;
	}
	
	public List<Patients> getPatientListByName(String patient_name) {
		List<Patients> patientList =  patientsDao.selectPatientsByName(patient_name);
		// 최초 진료 기록, 최근 진료 기록 setter 
		for(int i=0; i<patientList.size(); i++) {
			String firstReceiptDate = patientsDao.selectFirstReceiptDate(patientList.get(i).getPatient_id());
			String lastReceiptDate = patientsDao.selectLastReceiptDate(patientList.get(i).getPatient_id());
			if(firstReceiptDate == null || lastReceiptDate == null) {
				firstReceiptDate = "진료 기록 없음";
				lastReceiptDate = "진료 기록 없음";
			}
			patientList.get(i).setFirstReceiptDate(firstReceiptDate);
			patientList.get(i).setLastReceiptDate(lastReceiptDate);
		}						
		return patientList;
	}
	
	public Patients getPatientById(int patient_id) {
		Patients patient = patientsDao.selectPatientById(patient_id);
		// 최초 진료 기록, 최근 진료 기록 setter 
		String firstReceiptDate =  patientsDao.selectFirstReceiptDate(patient_id);
		String lastReceiptDate = patientsDao.selectLastReceiptDate(patient_id);
		if(firstReceiptDate == null || lastReceiptDate == null) {
			firstReceiptDate = "진료 기록 없음";
			lastReceiptDate = "진료 기록 없음";
		}
		patient.setFirstReceiptDate(firstReceiptDate);
		patient.setLastReceiptDate(lastReceiptDate);
		return patient;
	}

	public int deletePatientById(int patient_id) {
		return patientsDao.deletePatientById(patient_id);
	}

	public int updatePatient(Patients patient) {
		// 주민번호 뒷자리 시작번호가 홀수이면 남자, 짝수이면 여자 
		int sex = Integer.parseInt(patient.getPatient_ssn().substring(7, 8));
		if(sex % 2 == 0) {
			patient.setPatient_sex("F");
		}else {
			patient.setPatient_sex("M");
		}			
		return patientsDao.updatePatient(patient);
	}

	public int insertReceipt(ReceiptAndOpinions receipt) {
		return receiptDao.insertReceipt(receipt);
	}

	public List<ReceiptAndOpinions> getReceiptList() {
		return receiptDao.selectAllReceipt();
	}

	public int deleteReceipttById(int receipt_id) {
		return receiptDao.deleteReceiptById(receipt_id);
	}

	public int updateReceipt(int receipt_id, String nextState) {
		return receiptDao.updateReceipt(receipt_id, nextState);
	}


	

}
