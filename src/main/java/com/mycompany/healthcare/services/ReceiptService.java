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
		return patientsDao.selectAllPatient();
	}
	
	public List<Patients> getPatientListByName(String patient_name) {
		return patientsDao.selectPatientsByName(patient_name);
	}

	public Patients getPatientById(int patient_id) {
		return patientsDao.selectPatientById(patient_id);
	}

	public int deletePatientById(int patient_id) {
		return patientsDao.deletePatientById(patient_id);
	}

	public Patients updatePatient(Patients patient) {
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

	public int updateReceipt(int patient_id, String nextState) {
		return receiptDao.updateReceipt(patient_id, nextState);
	}

	

}
