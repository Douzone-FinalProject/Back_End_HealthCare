package com.mycompany.healthcare.services;

import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.mycompany.healthcare.dao.ReservationsDao;
import com.mycompany.healthcare.dto.Patients;
import com.mycompany.healthcare.dto.ReservationSMS;
import com.mycompany.healthcare.dto.Reservations;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;


@Service
@PropertySource("classpath:sms.properties")
public class ReservationService {

	@Autowired
	private ReservationsDao reservationsDao;
	
	@Value("${api_key}")
	private String api_key;
	@Value("${api_secret}")
	private String api_secret;
	
	public List<Reservations> getAllReservation() {
		return reservationsDao.selectAllReservation();
	}
	
	public Reservations getReservationById(int reservation_id) {
		return reservationsDao.selectReservationById(reservation_id);
	}
	
	public List<Reservations> getReservationByName(String reservation_name) {
		return reservationsDao.selectReservationByName(reservation_name);
	}

	public int insertReservation(Reservations reservation) {
		return reservationsDao.insertReservation(reservation);
	}

	public int deleteReservationById(int reserve_id) {
		return reservationsDao.deleteReservationById(reserve_id);
	}

	public int updateReservation(Reservations reservation) {
		return reservationsDao.updateReservation(reservation);
	}
	
	// https://developer.coolsms.co.kr/JAVA_SDK_EXAMPLE_Message
	public void sendSMS(ReservationSMS reservationSMS) {
		Message coolsms = new Message(api_key, api_secret);
		
		// 4 params(to, from, type, text) are mandatory. must be filled
	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", reservationSMS.getPhone());	// 수신전화번호
	    params.put("from", "01059067787");	// 발신전화번호
	    params.put("type", "SMS");
	    params.put("text", reservationSMS.getContent()); // 메세지 내용 
		
	    try {
	      JSONObject obj = (JSONObject) coolsms.send(params);
	      System.out.println(obj.toString());
	    } catch (CoolsmsException e) {
	      System.out.println(e.getMessage());
	      System.out.println(e.getCode());
	    }
	}

	public Integer checkPatientVisited(String reservation_name, String reservation_phone) {
		return reservationsDao.checkPatientVisited(reservation_name, reservation_phone);

	}

   
}
