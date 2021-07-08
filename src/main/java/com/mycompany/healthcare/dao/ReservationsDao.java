package com.mycompany.healthcare.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mycompany.healthcare.dto.Reservations;


@Mapper
public interface ReservationsDao {

	public List<Reservations> selectAllReservation();
	public Reservations selectReservationById(int reservation_id);
	public List<Reservations> selectReservationByName(String reservation_name);
	public int insertReservation(Reservations reservation);
	public int deleteReservationById(int reserve_id);
	public int updateReservation(Reservations reservation);
	
}
