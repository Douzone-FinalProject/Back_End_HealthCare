package com.mycompany.healthcare.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.healthcare.security.JwtUtil;
import com.mycompany.healthcare.services.AuthService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@Resource(name="daoAuthenticationManager")
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/login")
	public Map<String, String> login(@RequestBody Map<String, String> userInfo) {
		Map<String, String> map = new HashMap<>();
		logger.info("!!!!!!!!!!!");
		try {
			String staff_login_id = userInfo.get("staff_login_id");
			String staff_login_pwd = userInfo.get("staff_login_pwd");
			int hospital_id = Integer.parseInt(userInfo.get("hospital_id"));
			String staff_role = userInfo.get("staff_role");
			//병원 정보 가져오기
			String hospital_name = authService.getHosiptalName(hospital_id);
			// 사용자 인증
			UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(staff_login_id, staff_login_pwd);
			Authentication authentication = authenticationManager.authenticate(upat);
			logger.info("#########");
			// Spring Security에 인증 객체 등록
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			// JWT 생성
			String jwtToken = JwtUtil.createToken(staff_login_id);
			
			//스태프 이름, 권한 가져오기
			String staffName = authService.getStaffName(staff_login_id);
			String staffRole = authService.getStaffRole(staff_login_id);
			logger.info("aaaaaaaaaaaaaaa---"+hospital_name);
			//DB에서 병원코드, 권한 비교
			int hospitalCount = authService.compareHospitalCode(staff_login_id, hospital_id);
			int roleCount = authService.compareRole(staff_login_id, staff_role);
			if(hospitalCount == 1 && roleCount == 1) {
				// JSON 응답 보내기
				map.put("staff_login_id", staff_login_id);
				map.put("authToken", jwtToken);
				map.put("login_status", "success");
				map.put("staffName", staffName);
				map.put("staffRole", staffRole);
				map.put("hospital_name", hospital_name);
				map.put("hospital_id", String.valueOf(hospital_id));
			} else if(hospitalCount == 0) {
				map.put("login_status", "hospitalIdFailure");
			} else {
				map.put("login_status", "roleFailure");
			}
			
		} catch(BadCredentialsException e) {
			map.put("login_status", "IdPwFailure");
			e.printStackTrace();
		} catch (Exception e) {
			map.put("login_status", "aaaaaa");
			e.printStackTrace();
		}
		
		return map;
	}
}
