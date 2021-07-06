package com.mycompany.healthcare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.healthcare.dao.DiagnosticListsDao;
import com.mycompany.healthcare.dao.MedicinesDao;
import com.mycompany.healthcare.dao.ReceiptAndOpinionsDao;
import com.mycompany.healthcare.dao.SearchsDao;
import com.mycompany.healthcare.dto.DiagnosticLists;
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
	
	public List<Medicines> getMedicines(String keyword) {
		return medicinesDao.searchMedicines(keyword);
	}

	public void getCreateRequestTestList(List<DiagnosticLists> keyword) {
		diagnosticListsDao.insertRequestTest(keyword);
		
	}

	public void updateReceiptState(int receipt_id) {
		receiptAndOpinionsDao.updateReceiptState(receipt_id);
		
	}



}