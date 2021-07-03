package com.mycompany.healthcare.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.healthcare.dto.Staffs;
import com.mycompany.healthcare.services.StaffsService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/test")
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private StaffsService staffsService;
	
	@GetMapping("")
	public Map<String, Object> getStaffsList() {
		logger.info("#########");
		
		List<Staffs> staffList = staffsService.getStaffList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", staffList);
		return map;
	}
}
