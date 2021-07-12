package com.mycompany.healthcare.services;

import java.util.List;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.healthcare.controller.ResultController;
import com.mycompany.healthcare.dao.DiagnosticListsDao;
import com.mycompany.healthcare.dao.DiagnosticResultsDao;
import com.mycompany.healthcare.dao.ReceiptAndOpinionsDao;
import com.mycompany.healthcare.dto.DiagnosticData;
import com.mycompany.healthcare.dto.DiagnosticResults;
import com.mycompany.healthcare.dto.PatientData;
import com.mycompany.healthcare.dto.ReceiptAndOpinions;
import com.mycompany.healthcare.dto.ResultData;

@Service
public class ResultService {
	
	private static final Logger logger = LoggerFactory.getLogger(ResultController.class);

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
	
	public PatientData getPatientDataBySpecimen(String diagnostic_specimen_number) {
		return diagnosticListsDao.getPatientDataBySpecimen(diagnostic_specimen_number);
	}

	public DiagnosticData getSpecimenData(String diagnostic_specimen_number) {
		return diagnosticListsDao.getSpecimenData(diagnostic_specimen_number);
	}
	
	public List<ResultData> getPreviousResultData(int receipt_id) {
		return diagnosticResultsDao.getPreviousResultData(receipt_id);
	}

	public boolean insertResultData(List<ResultData> resultData) {
		boolean result = false;
		int row = diagnosticResultsDao.insertResultData(resultData);
		if (row != 0) {
			result = true;
		}
		return result;
	}

	public List<ResultData> getPreviousResultDataByNew(int receipt_id) {
		return diagnosticResultsDao.getPreviousResultDataByNew(receipt_id);
	}
	
	public boolean updateResultDataBySpecimen(JSONArray parseResult) {
		try {
			int diagnostic_results_id = 0;
			for (int index = 0; index < parseResult.length(); index++) {
				ObjectMapper objectMapper = new ObjectMapper();
				DiagnosticResults resultInfo = objectMapper.readValue(parseResult.get(index).toString(), DiagnosticResults.class);
				logger.info("########" + resultInfo);
				diagnostic_results_id = resultInfo.getDiagnostic_results_id();
				int rows = diagnosticResultsDao.updateResultDataBySpecimen(resultInfo);
				if(rows<1) {
					return false;
				}
			}
			logger.info("aaaaadddd"+diagnostic_results_id);
			diagnosticListsDao.updateFinishedResultState(diagnostic_results_id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean updateResultDataByReceipt(JSONArray parseResult) {
		try {
			int diagnostic_results_id = 0;
			for (int index = 0; index < parseResult.length(); index++) {
				ObjectMapper objectMapper = new ObjectMapper();
				DiagnosticResults resultInfo = objectMapper.readValue(parseResult.get(index).toString(), DiagnosticResults.class);
				logger.info("########" + resultInfo);
				diagnostic_results_id = resultInfo.getDiagnostic_results_id();
				int rows = diagnosticResultsDao.updateResultDataByReceipt(resultInfo);
				if(rows<1) {
					return false;
				}
			}
			receiptAndOpinionsDao.updateFinishedResultStateByReceipt(diagnostic_results_id);
			diagnosticListsDao.updateAllFinishedResultStateByReceipt(diagnostic_results_id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public List<DiagnosticResults> getCheckPreviousResult(String receipt_id) {
		return diagnosticResultsDao.getCheckPreviousResult(receipt_id);
	}

	public boolean updateinsertResultData(List<ResultData> resultData) {
		boolean result = false;
		int row = diagnosticResultsDao.updateinsertResultData(resultData);
		if (row != 0) {
			result = true;
		}
		return result;
	}
	
}
