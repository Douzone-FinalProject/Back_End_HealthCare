package com.mycompany.healthcare.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.healthcare.dto.DiagnosticData;
import com.mycompany.healthcare.dto.DiagnosticResults;
import com.mycompany.healthcare.dto.PatientData;
import com.mycompany.healthcare.dto.ReceiptAndOpinions;
import com.mycompany.healthcare.dto.ResultData;
import com.mycompany.healthcare.services.ResultService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/result")
public class ResultController {
	
	private static final Logger logger = LoggerFactory.getLogger(ResultController.class);
	
	@Autowired
	private ResultService resultService;
	
	@GetMapping("/getReceiptData")
	public Map<String, Object> getReceiptData(String patient_name, String receipt_datetime) {
		logger.info("getReceiptData --- " + receipt_datetime);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<ReceiptAndOpinions> receiptData = resultService.getReceiptData(patient_name, receipt_datetime);
			map.put("receiptData", receiptData);
			logger.info("receiptData --- " + receiptData);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@GetMapping("/getDiagnosticData")
	public Map<String, Object> getDiagnosticData(String patient_name, String receipt_datetime) {
		logger.info("getDiagnosticData --- " + patient_name);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<DiagnosticData> diagnosticData = resultService.getDiagnosticData(patient_name, receipt_datetime);
			map.put("diagnosticData", diagnosticData);
			logger.info("diagnosticData --- " + diagnosticData);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@GetMapping("/getResultDataByReceipt")
	public Map<String, Object> getResultDataByReceipt(String receipt_id) {
		logger.info("getResultDataByReceipt --- " + receipt_id);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<ResultData> resultData = resultService.getResultDataByReceipt(receipt_id);
			map.put("resultData", resultData);
			logger.info("resultData --- " + resultData);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@GetMapping("/getResultDataBySpecimen")
	public Map<String, Object> getResultDataBySpecimen(String diagnostic_specimen_number) {
		logger.info("getResultDataByReceipt --- " + diagnostic_specimen_number);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<ResultData> resultData = resultService.getResultDataBySpecimen(diagnostic_specimen_number);
			map.put("resultData", resultData);
			logger.info("resultData --- " + resultData);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@GetMapping("/getPatientData")
	public Map<String, Object> getPatientData(String receipt_id) {
		logger.info("getPatientData --- " + receipt_id);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			PatientData patientData = resultService.getPatientData(receipt_id);
			map.put("patientData", patientData);
			logger.info("patientData --- " + patientData);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@GetMapping("/getPatientDataBySpecimen")
	public Map<String, Object> getPatientDataBySpecimen(String diagnostic_specimen_number) {
		logger.info("getPatientDataBySpecimen --- " + diagnostic_specimen_number);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			PatientData patientData = resultService.getPatientDataBySpecimen(diagnostic_specimen_number);
			map.put("patientData", patientData);
			logger.info("patientData --- " + patientData);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@GetMapping("/getSpecimenData")
	public Map<String, Object> getSpecimenData(String diagnostic_specimen_number) {
		logger.info("getSpecimenData --- " + diagnostic_specimen_number);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			DiagnosticData specimenData = resultService.getSpecimenData(diagnostic_specimen_number);
			map.put("specimenData", specimenData);
			logger.info("specimenData --- " + specimenData);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@PostMapping("/insertResultData")
	public Map<String, Object> insertResultData(@RequestBody String receipt_id) {
		logger.info("insertResultData --- " + receipt_id);
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject jObject = new JSONObject(receipt_id);
		int ParseReceipt_id = jObject.getInt("receipt_id");
		logger.info("parseJson --- " + ParseReceipt_id);
		try {
			List<ResultData> resultData = resultService.getPreviousResultData(ParseReceipt_id);
			logger.info("##########resultData ----" + resultData);
			List<ResultData> resultData2 = resultService.getPreviousResultDataByNew(ParseReceipt_id);
			logger.info("##########resultData2 ----" + resultData2);
			resultService.insertResultData(resultData2);
			boolean result = resultService.updateinsertResultData(resultData);
			if (result) {
				map.put("result", "success");
			} else {
				map.put("result", "failure");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@PostMapping("/insertResultDataByNew")
	public Map<String, Object> insertResultDataByNew(@RequestBody String receipt_id) {
		logger.info("insertResultDataByNew --- " + receipt_id);
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject jObject = new JSONObject(receipt_id);
		int ParseReceipt_id = jObject.getInt("receipt_id");
		logger.info("parseJson --- " + ParseReceipt_id);
		try {
			List<ResultData> resultData = resultService.getPreviousResultDataByNew(ParseReceipt_id);
			logger.info("##########resultData ----" + resultData);
			boolean result = resultService.insertResultData(resultData);
			if (result) {
				map.put("result", "success");
			} else {
				map.put("result", "failure");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@PutMapping("/updateResultDataBySpecimen")
	public Map<String, Object> updateResultDataBySpecimen(@RequestBody String result) {
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject jObject = new JSONObject(result);
		JSONArray parseResult = jObject.getJSONArray("result");
		logger.info("updateResultDataBySpecimen --- " + parseResult);
		try {
			boolean row = resultService.updateResultDataBySpecimen(parseResult);
			map.put("row", row);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@PutMapping("/updateResultDataByReceipt")
	public Map<String, Object> updateResultDataByReceipt(@RequestBody String result) {
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject jObject = new JSONObject(result);
		JSONArray parseResult = jObject.getJSONArray("result");
		logger.info("updateResultDataByReceipt --- " + parseResult);
		try {
			boolean row = resultService.updateResultDataByReceipt(parseResult);
			map.put("row", row);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@GetMapping("/getCheckPreviousResult")
	public Map<String, Object> getCheckPreviousResult(String receipt_id) {
		logger.info("getCheckPreviousResult --- " + receipt_id);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<DiagnosticResults> PrevResultData = resultService.getCheckPreviousResult(receipt_id);
			map.put("PrevResultData", PrevResultData);
			logger.info("PrevResultData --- " + PrevResultData);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
