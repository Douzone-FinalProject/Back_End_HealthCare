package com.mycompany.healthcare.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.healthcare.security.JwtUtil;
import com.mycompany.healthcare.services.StaffsService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private StaffsService staffsService;
	
	@PostMapping("/login")
	public Map<String, String> login(@RequestBody Map<String, String> userInfo) {
		logger.info("#########");
		String staff_login_id = userInfo.get("staff_login_id");
		String staff_login_pwd = userInfo.get("staff_login_pwd");
//		String hospital_id = userInfo.get("hospital_id");
//		String staff_role = userInfo.get("staff_role");
		
		// 사용자 인증
		UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(staff_login_id, staff_login_pwd);
		Authentication authentication = authenticationManager.authenticate(upat);
		
		// Spring Security에 인증 객체 등록
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		// JWT 생성
		String jwtToken = JwtUtil.createToken(staff_login_id);
		
		// JSON 응답 보내기
		Map<String, String> map = new HashMap<>();
		map.put("staff_login_id", staff_login_id);
		map.put("authToken", jwtToken);
		
		return map;
	}
}
