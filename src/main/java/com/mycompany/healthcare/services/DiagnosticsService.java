package com.mycompany.healthcare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.healthcare.dao.DiagnosticListsDao;
import com.mycompany.healthcare.dao.MedicinePresDao;
import com.mycompany.healthcare.dao.MedicinesDao;
import com.mycompany.healthcare.dao.ReceiptAndOpinionsDao;
import com.mycompany.healthcare.dao.SearchsDao;
import com.mycompany.healthcare.dto.DiagnosticLists;
import com.mycompany.healthcare.dto.MedicinePres;
import com.mycompany.healthcare.dto.Medicines;
import com.mycompany.healthcare.dto.ReceiptAndOpinions;
import com.mycompany.healthcare.dto.Searchs;

@Service
public class DiagnosticsService {
	@Autowired
	private SearchsDao searchsDao;
	
	@Autowired
	private MedicinesDao medicinesDao;

	@Autowired
	private DiagnosticListsDao diagnosticListsDao;
	
	@Autowired
	private ReceiptAndOpinionsDao receiptAndOpinionsDao;
	
	@Autowired
	private MedicinePresDao medicinePresDao;

	public List<Searchs> getSearchList(String symptom_name) {
		List<Searchs> searchList = searchsDao.selectSearchList(symptom_name);
		return searchList;
	}
	
	public List<ReceiptAndOpinions> getSearchPatientIdOpinionList(String patient_id) {
		List<ReceiptAndOpinions> searchPatientIdOpinionList = receiptAndOpinionsDao.selectSearchPatientIdOpinionList(patient_id);
		return searchPatientIdOpinionList;
	}

	public List<ReceiptAndOpinions> getSearchDateOpinionList(String receipt_datetime) {
		List<ReceiptAndOpinions> searchDateOpinionList = receiptAndOpinionsDao.selectSearchDateOpinionList(receipt_datetime);
		return searchDateOpinionList;
	}
	
	public List<ReceiptAndOpinions> getSearchPatientNameOpinionList(String patient_name) {
		List<ReceiptAndOpinions> searchPatientNameOpinionList = receiptAndOpinionsDao.selectSearchPatientNameOpinionList(patient_name);
		return searchPatientNameOpinionList;
	}
	
	public List<ReceiptAndOpinions> getSearchPatientIdAndDateList(String patient_id, String receipt_datetime) {
		List<ReceiptAndOpinions> searchPatientIdAndDateList = receiptAndOpinionsDao.selectSearchPatientIdAndDateList(patient_id, receipt_datetime);
		return searchPatientIdAndDateList;
	}
	
	public List<ReceiptAndOpinions> getSearchPatientIdAndNameList(String patient_name, String patient_id) {
		List<ReceiptAndOpinions> searchPatientIdAndNameList = receiptAndOpinionsDao.selectSearchPatientIdAndNameList(patient_name, patient_id);
		return searchPatientIdAndNameList;
	}
	
	public List<ReceiptAndOpinions> getSearchPatientNameAndDateList(String patient_name, String receipt_datetime) {
		List<ReceiptAndOpinions> searchPatientNameAndDateList = receiptAndOpinionsDao.selectSearchPatientNameAndDateList(patient_name, receipt_datetime);
		return searchPatientNameAndDateList;
	}
	
	public List<ReceiptAndOpinions> getSearchAllList(String patient_id, String patient_name, String receipt_datetime) {
		List<ReceiptAndOpinions> searchAllList = receiptAndOpinionsDao.selectSearchAllList(patient_id, patient_name, receipt_datetime);
		return searchAllList;
	}
	
	public List<Medicines> getMedicines(String keyword) {
		return medicinesDao.searchMedicines(keyword);
	}

	public void getCreateRequestTestList(List<DiagnosticLists> keyword) {
		diagnosticListsDao.insertRequestTest(keyword);
		
	}

	public void updateReceiptState(int receipt_id) {
		receiptAndOpinionsDao.updateReceiptState(receipt_id);
		
	}

	public List<ReceiptAndOpinions> getFatientOpinionsList(String patient_id) {
		List<ReceiptAndOpinions> fatientOpinionsList = receiptAndOpinionsDao.selectFatientOpinionsList(patient_id);
		return fatientOpinionsList;
	}

	public void getCreateOpinion(ReceiptAndOpinions newOpinion) {
		int receipt_id = newOpinion.getReceipt_id();
		String receipt_opinion = newOpinion.getReceipt_opinion();
		String receipt_uniqueness = newOpinion.getReceipt_uniqueness();
		receiptAndOpinionsDao.updateInsertOpinion(receipt_id, receipt_opinion, receipt_uniqueness);
		
	}

	public void createMedicinesList(List<MedicinePres> cmlist) {
		medicinePresDao.insertMedicinesList(cmlist);
		
	}


	

	
}