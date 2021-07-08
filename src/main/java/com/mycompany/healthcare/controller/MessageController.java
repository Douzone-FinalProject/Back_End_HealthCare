package com.mycompany.healthcare.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.healthcare.dto.Messages;
import com.mycompany.healthcare.dto.Patients;
import com.mycompany.healthcare.dto.Staffs;
import com.mycompany.healthcare.services.MessageService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/message")
public class MessageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	@Autowired
	private MessageService messageService;
	
	@GetMapping("/sendRedisMessage")
	public void sendRedisMessage(String topic, String content, HttpServletResponse res) {
		logger.info("sendMessage");
		try {
			logger.info(topic+"----"+content);
			redisTemplate.convertAndSend(topic, content);
		
			JSONObject json = new JSONObject();
			json.put("result", "success");
			res.setContentType("application/json; charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.write(json.toString());
			writer.flush();
			writer.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/getMessageList")
	public Map<String, Object> getMessageList(String staff_login_id) {
		logger.info("getMessageList --- " + staff_login_id);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Messages> messageList = messageService.getMessageList(staff_login_id);
			map.put("messageList", messageList);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@PostMapping("/sendMessage")
	public Map<String, Object> sendMessage(@RequestBody Messages messageInfo) {
		logger.info("sendMessage --- " + messageInfo);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			boolean result = messageService.addMessage(messageInfo);
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
	
	@GetMapping("/getHospitalStaff")
	public Map<String, Object> getHospitalStaff(String staff_login_id) {
		logger.info("getHospitalStaff --- " + staff_login_id);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Staffs> staffList = messageService.getStaffList(staff_login_id);
			map.put("staffList", staffList);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@DeleteMapping("/{message_id}")
	public void deleteMessage(@PathVariable int message_id, HttpServletResponse response) {
		boolean result = messageService.deleteMessage(message_id);
		
		if(!result) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
	
}
