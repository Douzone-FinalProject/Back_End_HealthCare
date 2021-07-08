package com.mycompany.healthcare.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.healthcare.dao.ReservationsDao;
import com.mycompany.healthcare.dto.Reservations;

@Service
public class ReservationService {

	@Autowired
	private ReservationsDao reservationsDao;
	
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

}
