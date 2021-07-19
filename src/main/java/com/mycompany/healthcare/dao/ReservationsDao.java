package com.mycompany.healthcare.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.mycompany.healthcare.dto.Reservations;


@Mapper
public interface ReservationsDao {

	public List<Reservations> selectAllReservation();
	public Reservations selectReservationById(int reservation_id);
	public List<Reservations> selectReservationByName(String reservation_name);
	public int isAlreadyReserved(String reservation_date);
	public int insertReservation(Reservations reservation);
	public int deleteReservationById(int reserve_id);
	public int updateReservation(Reservations reservation);
	public Integer checkPatientVisited(@Param("reservation_name") String reservation_name, 
										@Param("reservation_phone") String reservation_phone);
	public Reservations selectNextReservation(int patient_id);

}
