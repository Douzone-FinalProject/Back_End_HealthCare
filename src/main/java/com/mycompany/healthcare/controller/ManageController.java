package com.mycompany.healthcare.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.healthcare.dto.Patients;
import com.mycompany.healthcare.dto.Staffs;
import com.mycompany.healthcare.services.StaffsService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/manage")
public class ManageController {
	
	private static final Logger logger = LoggerFactory.getLogger(ManageController.class);
	
	@Autowired
	private StaffsService staffsService;
	
	
	@GetMapping("/staffList")
	public Map<String, Object> staffList(int hospital_id) {
		List<Staffs> staffList2 = staffsService.getStaffList(hospital_id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("staffList2", staffList2);
		return map;
	}
	
	@PostMapping("/addNewEmployee")
	public void addNewEmployee(@RequestBody Staffs employee) {
		BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
		employee.setStaff_login_pwd(bpe.encode(employee.getStaff_login_pwd()));
		logger.info(employee.getHospital_id()+"");
		staffsService.addStaff(employee);
	}
	
	@GetMapping("/readStaff")
	public Map<String, Object> readStaff(int staff_id) {
		Staffs staffInfo = staffsService.getStaff(staff_id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("staffInfo", staffInfo);
		return map;
	}
	
	@DeleteMapping("/staff/{staff_id}")
	public void deleteStaff(@PathVariable("staff_id") int staff_id) {
		logger.info(""+staff_id);
		staffsService.deleteStaff(staff_id);
	}
	
	@GetMapping("/receiptCount")
	public Map<String, Object> receiptCount() {
		int receiptCounts = staffsService.getReceiptCount();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("receiptCounts", receiptCounts);
		return map;
	}
	
	@GetMapping("/testCount")
	public Map<String, Object> testCount() {
		int testCounts = staffsService.getTestCount();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("testCounts", testCounts);
		return map;
	}
	
	@GetMapping("/medicinePresCount")
	public Map<String, Object> medicinePrestCount() {
		int medicinePresCounts = staffsService.getMedicinePresCount();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("medicinePresCounts", medicinePresCounts);
		return map;
	}
}
