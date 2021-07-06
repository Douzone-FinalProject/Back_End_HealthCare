package com.mycompany.healthcare.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.healthcare.dto.DiagnosticLists;
import com.mycompany.healthcare.dto.MedicinePres;
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
	
	@GetMapping("/searchPatientNameOpinion")
	public Map<String, Object> searchPatientNameOpinion(String patient_name) {
		List<ReceiptAndOpinions> searchPatientNameOpinionList = diagnosticsService.getSearchPatientNameOpinionList(patient_name);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchPatientNameOpinionList", searchPatientNameOpinionList);

		return map;
	}
	
	@GetMapping("/searchPatientIdAndDate")
	public Map<String, Object> searchPatientNameOpinion(String patient_id ,String receipt_datetime) {
		List<ReceiptAndOpinions> searchPatientIdAndDateList = diagnosticsService.getSearchPatientIdAndDateList(patient_id, receipt_datetime);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchPatientIdAndDateList", searchPatientIdAndDateList);

		return map;
	}
	
	@GetMapping("/searchPatientIdAndName")
	public Map<String, Object> searchPatientIdAndName(String patient_name ,String patient_id) {
		List<ReceiptAndOpinions> searchPatientIdAndNameList = diagnosticsService.getSearchPatientIdAndNameList(patient_name, patient_id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchPatientIdAndNameList", searchPatientIdAndNameList);

		return map;
	}
	
	@GetMapping("/searchPatientNameAndDate")
	public Map<String, Object> searchPatientNameAndDate(String patient_name ,String receipt_datetime) {
		List<ReceiptAndOpinions> searchPatientNameAndDateList = diagnosticsService.getSearchPatientNameAndDateList(patient_name, receipt_datetime);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchPatientNameAndDateList", searchPatientNameAndDateList);

		return map;
	}
	
	@GetMapping("/searchAll")
	public Map<String, Object> searchAll(String patient_id, String patient_name ,String receipt_datetime) {
		List<ReceiptAndOpinions> searchAllList = diagnosticsService.getSearchAllList(patient_id, patient_name, receipt_datetime);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchAllList", searchAllList);

		return map;
	}
	
	@GetMapping("/medicine")
	public List<Medicines> searchMedicine(@RequestParam String keyword) {
		return diagnosticsService.getMedicines(keyword); 
	}
	
	@PostMapping("/createRequestTest")
	public void createRequestTest(@RequestBody List<DiagnosticLists> keyword) {
		int receipt_id = keyword.get(0).getReceipt_id();
		diagnosticsService.getCreateRequestTestList(keyword);
		diagnosticsService.updateReceiptState(receipt_id);
		
	}
	
	
	@GetMapping("/fatientOpinions")
	public Map<String, Object> fatientOpinions(String patient_id) {
		List<ReceiptAndOpinions> fatientOpinionsList = diagnosticsService.getFatientOpinionsList(patient_id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fatientOpinionsList", fatientOpinionsList);

		return map;
	}
	
	@PostMapping("/createOpinion")
	public void createOpinion(@RequestBody ReceiptAndOpinions newOpinion) {
		
		diagnosticsService.getCreateOpinion(newOpinion);
	}
	
	@PostMapping("/createMedicines")
	public void createMedicines(@RequestBody List<MedicinePres> cmlist) {
		logger.info(""+ cmlist);
		int receipt_id = cmlist.get(0).getReceipt_id();
		logger.info(""+receipt_id);
		diagnosticsService.createMedicinesList(cmlist);
	}


}
