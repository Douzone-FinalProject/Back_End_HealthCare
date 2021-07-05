package com.mycompany.healthcare.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.healthcare.dto.Searchs;
import com.mycompany.healthcare.services.DiagnosticsService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/diagnostic")
public class DiagnosticController {
	
	private static final Logger logger = LoggerFactory.getLogger(DiagnosticController.class);
	
	@Autowired DiagnosticsService diagnosticsService;
	
	
	@GetMapping("/searchSymptom")
	public Map<String, Object> searchSymptom(String symptom_name) {
		logger.info("111111");
		List<Searchs> searchList = diagnosticsService.getSearchList(symptom_name);
		logger.info(searchList+"");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", searchList);
		

		return map;
	}

}
