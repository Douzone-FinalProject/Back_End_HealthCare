package com.mycompany.healthcare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.healthcare.dao.DiagnosticListsDao;
import com.mycompany.healthcare.dao.DiagnosticResultsDao;
import com.mycompany.healthcare.dao.ReceiptAndOpinionsDao;
import com.mycompany.healthcare.dto.DiagnosticData;
import com.mycompany.healthcare.dto.PatientData;
import com.mycompany.healthcare.dto.ReceiptAndOpinions;
import com.mycompany.healthcare.dto.ResultData;

@Service
public class ResultService {

	@Autowired
	private ReceiptAndOpinionsDao receiptAndOpinionsDao;
	@Autowired
	private DiagnosticListsDao diagnosticListsDao;
	@Autowired
	private DiagnosticResultsDao diagnosticResultsDao;
	
	public List<ReceiptAndOpinions> getReceiptData(String patient_name, String receipt_datetime) {
		if(!patient_name.equals("")) {
			return receiptAndOpinionsDao.getReceiptDataByName(patient_name, receipt_datetime);
		} else {
			return receiptAndOpinionsDao.getReceiptDataByDate(receipt_datetime);
		}
	}

	public List<DiagnosticData> getDiagnosticData(String patient_name, String receipt_datetime) {
		if(!patient_name.equals("")) {
			return diagnosticListsDao.getDiagnosticDataByName(patient_name, receipt_datetime);
		} else {
			return diagnosticListsDao.getDiagnosticDataByDate(receipt_datetime);
		}
	}

	public List<ResultData> getResultDataByReceipt(String receipt_id) {
		return diagnosticResultsDao.getResultDataByReceipt(receipt_id);
	}

	public List<ResultData> getResultDataBySpecimen(String diagnostic_specimen_number) {
		return diagnosticResultsDao.getResultDataBySpecimen(diagnostic_specimen_number);
	}

	public PatientData getPatientData(String receipt_id) {
		return diagnosticListsDao.getPatientData(receipt_id);
	}

	public DiagnosticData getSpecimenData(String diagnostic_specimen_number) {
		return diagnosticListsDao.getSpecimenData(diagnostic_specimen_number);
	}

	public int updateResultDataBySpecimen(String result) {
		return diagnosticResultsDao.updateResultDataBySpecimen(result);
	}
	
}
