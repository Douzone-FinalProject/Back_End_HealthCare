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
			List<Reservations> reservations = reservationService.getReservationByName(reservation_name);
			map.put("reservations", reservations);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@PostMapping("")
	public Map<String, Object> insertReservation(@RequestBody Reservations reservation) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int row = reservationService.insertReservation(reservation);
			map.put("row", row);
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
			int row = reservationService.updateReservation(reservation);
			map.put("row", row);
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
			reservationService.sendSMS(reservationSMS);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
