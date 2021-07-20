package com.mycompany.healthcare.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.mycompany.healthcare.dto.ReservationSMS;
import com.mycompany.healthcare.dto.Reservations;
import com.mycompany.healthcare.services.ReservationService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/reserve")
public class ReservationController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
	
	@Autowired
	private ReservationService reservationService;
	
	@GetMapping("")
	public Map<String, Object> getAllReservation(){
		Map<String, Object> map = new HashMap<>();
		try {
			List<Reservations> reservations = reservationService.getAllReservation();
			map.put("reservations", reservations);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@GetMapping("/id/{id}")
	public Map<String, Object> getReservationById(@PathVariable("id")int reservation_id){
		Map<String, Object> map = new HashMap<>();
		try {
			Reservations reservation = reservationService.getReservationById(reservation_id);
			map.put("reservation", reservation);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@GetMapping("/name/{name}")
	public Map<String, Object> getReservationByName(@PathVariable("name") String reservation_name){
		Map<String, Object> map = new HashMap<>();
		try {
			/*
			 지금 출력하는 것은 한 사람의 과거 예약 기록까지 나오기 때문에 
			 과거 기록은 싹 없애고 가장 마지막 예약 날짜만 출력하도록 해야 한다. 
			*/
			logger.info("123: "+reservation_name);
			if(!reservation_name.equals("")) {
				List<Reservations> reservations = reservationService.getReservationByName(reservation_name);			
				map.put("reservations", reservations); // 여기에 다음 예약 날짜가 포함되어야 한다. 
			}else {
				map.put("reservations", new ArrayList<>());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	// 다음 예약 날짜 알아내기 - patient_id
	@GetMapping("/next/{patient_id}")
	public Map<String, Object> geNextReservation(@PathVariable("patient_id") int patient_id){
		Map<String, Object> map = new HashMap<>();
		try {
			Reservations reservation = reservationService.getNextReservation(patient_id);
			map.put("reservation", reservation); // 프론트에서 날짜만 뽑아서 쓰기 
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@PostMapping("")
	public Map<String, Object> insertReservation(@RequestBody Reservations reservation) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			logger.info(reservation.toString());
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");
			Date targetDate = dateFormat.parse(reservation.getReservation_datetime());
			String currentDate = dateFormat.format(new Date());
			
			String time = reservation.getReservation_datetime().substring(11, 16);
			int hour = Integer.parseInt(time.split(":")[0]);
			int minute = Integer.parseInt(time.split(":")[1]);
			boolean isReserved = reservationService.isAlreadyReserved(reservation.getReservation_datetime());
			
			// 날짜를 통해서 요일을 뽑아오기 
			String date = reservation.getReservation_datetime().substring(0,11);
			String dayOfWeek = reservationService.getDayOfWeek(date);
			
			if(targetDate.before(dateFormat.parse(currentDate))){
				map.put("errorMessage", "현재시각 이후에 예약이 가능합니다.");
	        }else if(isReserved) {
				map.put("errorMessage", "이 시간대에 예약이 이미 존재합니다.");
	        }else if(dayOfWeek.equals("SAT") && hour >= 12) {
				map.put("errorMessage", "토요일은 오전만 운영합니다.");
			}else if(hour < 8 || hour > 18 || dayOfWeek.equals("SUN")) { 	
				map.put("errorMessage", "병원을 운영하지 않는 시간대입니다.");
			}else if(hour == 12) { 
				map.put("errorMessage", "병원 점심시간입니다.");
			}else if(minute != 0 && minute != 30) {
				map.put("errorMessage", "예약은 30분 단위로 이루어집니다.");
			}else {
				int row = reservationService.insertReservation(reservation);
				logger.info("insert: " + row); 	
				map.put("row", row);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	

	@DeleteMapping("/{id}")
	public Map<String, Object> removeReserveById(@PathVariable("id") int reserve_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int row = reservationService.deleteReservationById(reserve_id);
			map.put("row", row);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	

	@PutMapping("")
	public Map<String, Object> updateReserve(@RequestBody Reservations reservation) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			logger.info(reservation.toString());
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");
			Date targetDate = dateFormat.parse(reservation.getReservation_datetime());
			String currentDate = dateFormat.format(new Date());
			
			String time = reservation.getReservation_datetime().substring(11, 16);
			int hour = Integer.parseInt(time.split(":")[0]);
			int minute = Integer.parseInt(time.split(":")[1]);
			boolean isReserved = reservationService.isAlreadyReserved(reservation.getReservation_datetime());
			
			// 날짜를 통해서 요일을 뽑아오기 
			String date = reservation.getReservation_datetime().substring(0,11);
			String dayOfWeek = reservationService.getDayOfWeek(date);
			
			if(targetDate.before(dateFormat.parse(currentDate))){
				map.put("errorMessage", "현재시각 이후에 예약이 가능합니다.");
	        }else if(isReserved) {
				map.put("errorMessage", "이 시간대에 예약이 이미 존재합니다.");
	        }else if(dayOfWeek.equals("SAT") && hour >= 12) {
				map.put("errorMessage", "토요일은 오전만 운영합니다.");
			}else if(hour < 8 || hour > 18 || dayOfWeek.equals("SUN")) { 	
				map.put("errorMessage", "병원을 운영하지 않는 시간대입니다.");
			}else if(hour == 12) { 
				map.put("errorMessage", "병원 점심시간입니다.");
			}else if(minute != 0 && minute != 30) {
				map.put("errorMessage", "예약은 30분 단위로 이루어집니다.");
			}else {
				int row = reservationService.updateReservation(reservation); 
				logger.info("update: " + row); 	
				map.put("row", row);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	// SMS 발송 
	@PostMapping("/sms")
	public void sendSMS(@RequestBody ReservationSMS reservationSMS) {
		try {
			logger.info(reservationSMS.toString());
			if(reservationSMS.getName() != null && reservationSMS.getContent() != null && reservationSMS.getPhone() != null) {
				reservationService.sendSMS(reservationSMS);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 예약시에 기존 환자인지 체크 
	@GetMapping("/checkPatient/{name}/{phone}")
	public Map<String, Object> checkPatientVisited(@PathVariable("name") String reservation_name, @PathVariable("phone") String reservation_phone){
		Map<String, Object> map = new HashMap<>();
		try {
			Integer patient_id = reservationService.checkPatientVisited(reservation_name, reservation_phone);
			logger.info("patient_id: " + String.valueOf(patient_id)); // null 
			map.put("patient_id", patient_id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	

}
