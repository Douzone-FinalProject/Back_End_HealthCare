package com.mycompany.healthcare.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mycompany.healthcare.dto.Patients;
import com.mycompany.healthcare.dto.ReceiptAndOpinions;
import com.mycompany.healthcare.services.ReceiptService;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/receipt")
public class ReceiptController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReceiptController.class);
	
	@Autowired
	private ReceiptService receiptService;
	
	// 모든 환자 리스트 
	@GetMapping("/patients")
	public Map<String, Object> getPatientList() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Patients> patientList = receiptService.getPatientList();
			map.put("patientList", patientList);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	// 환자 이름 검색 
	@GetMapping("/patients/name/{name}")
	public Map<String, Object> getPatientList(@PathVariable("name") String patient_name) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Patients> patientList = receiptService.getPatientListByName(patient_name);
			map.put("patientList", patientList);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	// 신규 환자 생성 
	@PostMapping("/addPatient")
	public Map<String, Object> addPatient(@RequestBody Patients patientInfo) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			boolean result = receiptService.addPatient(patientInfo);
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
	
	@GetMapping("/patient/{id}")
	public Map<String, Object> getPatientById(@PathVariable("id") int patient_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Patients patient = receiptService.getPatientById(patient_id);
			logger.info("hello: " + patient.toString());
			map.put("patient", patient);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@DeleteMapping("/patient/{id}")
	public Map<String, Object> removePatientById(@PathVariable("id") int patient_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int row = receiptService.deletePatientById(patient_id);
			map.put("row", row);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	@PutMapping("/patient")
	public Map<String, Object> updatePatient(@RequestBody Patients patient) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int row = receiptService.updatePatient(patient);
			map.put("row", row);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	// 접수 
	@PostMapping("")
	public Map<String, Object> insertReceipt(@RequestBody Patients patient) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int row = receiptService.insertReceipt(patient.getPatient_id());
			map.put("row", row);
			int receipt_id = receiptService.getReceiptIdByPatientId(patient.getPatient_id()); // 차트번호로 접수번호 뽑아오기 
			map.put("receipt_id", receipt_id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	// 접수 리스트 불러오기 - 완료상태 제외
	@GetMapping("")
	public Map<String, Object> getReceiptList() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<ReceiptAndOpinions> receiptList = receiptService.getReceiptList();
			map.put("receiptList", receiptList);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	// 접수 취소 
	@DeleteMapping("/{id}")
	public Map<String, Object> removeReceiptById(@PathVariable("id") int receipt_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int row = receiptService.deleteReceipttById(receipt_id);
			map.put("row", row);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	// 진료 보내기 receipt_state [대기 -> 진료중], [수납전 -> 완료]
	@PutMapping("/{id}/{nextState}")
	public Map<String, Object> updateReceipt(@PathVariable("id") int receipt_id, @PathVariable("nextState") String nextState) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int row = receiptService.updateReceipt(receipt_id, nextState);
			map.put("row", row);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	


}
