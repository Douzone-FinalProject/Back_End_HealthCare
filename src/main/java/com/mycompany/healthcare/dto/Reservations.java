package com.mycompany.healthcare.dto;

import java.util.Date;

public class Reservations {
	private int reservation_id;
	private String reservation_datetime;
	private String reservation_name;
	private String reservation_phone;
	private String reservation_reason;
	private int patient_id;
	public int getReservation_id() {
		return reservation_id;
	}
	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}
	public String getReservation_datetime() {
		return reservation_datetime;
	}
	public void setReservation_datetime(String reservation_datetime) {
		this.reservation_datetime = reservation_datetime;
	}
	public String getReservation_name() {
		return reservation_name;
	}
	public void setReservation_name(String reservation_name) {
		this.reservation_name = reservation_name;
	}
	public String getReservation_phone() {
		return reservation_phone;
	}
	public void setReservation_phone(String reservation_phone) {
		this.reservation_phone = reservation_phone;
	}
	public String getReservation_reason() {
		return reservation_reason;
	}
	public void setReservation_reason(String reservation_reason) {
		this.reservation_reason = reservation_reason;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	@Override
	public String toString() {
		return "Reservations [reservation_id=" + reservation_id + ", reservation_datetime=" + reservation_datetime
				+ ", reservation_name=" + reservation_name + ", reservation_phone=" + reservation_phone
				+ ", reservation_reason=" + reservation_reason + ", patient_id=" + patient_id + "]";
	}
	
	
}
