package com.mycompany.healthcare.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mycompany.healthcare.dto.Medicines;
import com.mycompany.healthcare.dto.ReceiptAndOpinions;
import com.mycompany.healthcare.dto.Searchs;
import com.mycompany.healthcare.services.DiagnosticsService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/diagnostic")
public class DiagnosticController {
	
	private static final Logger logger = LoggerFactory.getLogger(DiagnosticController.class);
	
	@Autowired DiagnosticsService diagnosticsService; 
	
	
	@GetMapping("/searchSymptom") //증상 검색
	public Map<String, Object> searchSymptom(String symptom_name) {
		List<Searchs> searchList = diagnosticsService.getSearchList(symptom_name);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", searchList);
		
		return map;
	}
	
	@GetMapping("/searchPatientIdOpinion")
	public Map<String, Object> searchPatientId(String patient_id) {
		List<ReceiptAndOpinions> searchPatientIdOpinionList = diagnosticsService.getSearchPatientIdOpinionList(patient_id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchPatientIdOpinionList", searchPatientIdOpinionList);

		return map;
	}
	
	@GetMapping("/searchDateOpinion")
	public Map<String, Object> searchDateOpinion(String receipt_datetime) {
		List<ReceiptAndOpinions> searchDateOpinionList = diagnosticsService.getSearchDateOpinionList(receipt_datetime);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchDateOpinionList", searchDateOpinionList);

		return map;
	}
	
	@GetMapping("/medicine")
	public List<Medicines> searchMedicine(@RequestParam String keyword) {
		logger.info(keyword);
		return diagnosticsService.getMedicines(keyword); 
	}


}
