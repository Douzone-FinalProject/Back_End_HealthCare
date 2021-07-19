package com.mycompany.healthcare.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.mycompany.healthcare.dao.ReservationsDao;
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

	public Boolean isAlreadyReserved(String reservation_date) {
		int result = reservationsDao.isAlreadyReserved(reservation_date);
		if(result > 0) {return true;}
		return false;
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

	// 다음 예약 날짜
	public Reservations getNextReservation(int patient_id) {
		return reservationsDao.selectNextReservation(patient_id);
	}

	// 특정 날짜의 요일 구하기 
	public String getDayOfWeek(String inputDate) {
		DateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
		String result = "";
		try {
			Date date = dataFormat.parse(inputDate);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int dayNum = calendar.get(Calendar.DAY_OF_WEEK);
			
			switch(dayNum) {
				case 1:
					result = "SUN";
					break;
				case 2:
					result = "MON";
					break;
				case 3:
					result = "TUE";
					break;
				case 4:
					result = "WED";
					break;
				case 5:
					result = "TUR";
					break;
				case 6:
					result = "FRI";
					break;
				case 7:
					result = "SAT";
					break;
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

   
}
