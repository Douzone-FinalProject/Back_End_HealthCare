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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.healthcare.dto.DiagnosticLists;
import com.mycompany.healthcare.dto.ReceiptAndOpinions;
import com.mycompany.healthcare.dto.StateCharts;
import com.mycompany.healthcare.dto.TestStateDetail;
import com.mycompany.healthcare.services.TestStateService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/teststate")
public class TestStateController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestStateController.class);
	
	@Autowired
	private TestStateService testStateService;
	
	// patientStateList
	@GetMapping("")
	public List<ReceiptAndOpinions> getPatientStateList(@RequestParam(defaultValue="전체") String type, @RequestParam(defaultValue="whole") String state) {
		return testStateService.getPatientStateList(type, state);
	}
	
	// testStateDetail
	@GetMapping("/detail")
	public List<TestStateDetail> getTestStateDetailList(@RequestParam int receiptId) {
		logger.info("" + receiptId);
		return testStateService.getTestStateDetailList(receiptId);
	}
	
	// testStateDetail 검사상태 수정
	@PutMapping("")
	public void updateStateDetail(@RequestBody Map<String, Object> updateData) {
		testStateService.updateStateDetail(updateData);
		// testStateDetail -> patientStateList 상태 바뀜
		testStateService.updatePatientState(updateData);
	}
	
	// PieChart
	@GetMapping("/statechart")
	public List<StateCharts> getStateChart() {
		return testStateService.getStateChart();
	}
	
	// updateReceiptState
	@PutMapping("/receiptstate")
	public void updateReceiptStates(@RequestBody Map<String, String> updateData) {
		testStateService.updateReceiptStates(updateData);
	}
	
//	@PostMapping("/img")
//	public void uploadImg(@) {
//		
//	}

}
