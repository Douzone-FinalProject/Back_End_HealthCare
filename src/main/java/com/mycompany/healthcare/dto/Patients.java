package com.mycompany.healthcare.dto;

import java.util.Date;

public class Patients {
	private int patient_id;
	private String patient_name;
	private String patient_ssn;
	private String patient_sex;
	private String patient_phone;
	private String patient_zipcode;
	private String patient_address;
	private String patient_detail_address;
	private String patient_blood_type;
	private int patient_max_bp;
	private int patient_min_bp;
	private int patient_pulse;
	private double patient_height;
	private double patient_weight;
	private String patient_guardian_name;
	private String patient_guardian_phone;
	private String patient_guardian_relationship;
	private String patient_register_date;
	private String firstReceiptDate; // 최초 진료 날짜 
	private String lastReceiptDate; // 최근 진료 날짜 

	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public String getPatient_ssn() {
		return patient_ssn;
	}
	public void setPatient_ssn(String patient_ssn) {
		this.patient_ssn = patient_ssn;
	}
	public String getPatient_sex() {
		return patient_sex;
	}
	public void setPatient_sex(String patient_sex) {
		this.patient_sex = patient_sex;
	}
	public String getPatient_phone() {
		return patient_phone;
	}
	public void setPatient_phone(String patient_phone) {
		this.patient_phone = patient_phone;
	}
	public String getPatient_zipcode() {
		return patient_zipcode;
	}
	public void setPatient_zipcode(String patient_zipcode) {
		this.patient_zipcode = patient_zipcode;
	}
	public String getPatient_address() {
		return patient_address;
	}
	public void setPatient_address(String patient_address) {
		this.patient_address = patient_address;
	}
	public String getPatient_detail_address() {
		return patient_detail_address;
	}
	public void setPatient_detail_address(String patient_detail_address) {
		this.patient_detail_address = patient_detail_address;
	}
	public String getPatient_blood_type() {
		return patient_blood_type;
	}
	public void setPatient_blood_type(String patient_blood_type) {
		this.patient_blood_type = patient_blood_type;
	}
	public int getPatient_max_bp() {
		return patient_max_bp;
	}
	public void setPatient_max_bp(int patient_max_bp) {
		this.patient_max_bp = patient_max_bp;
	}
	public int getPatient_min_bp() {
		return patient_min_bp;
	}
	public void setPatient_min_bp(int patient_min_bp) {
		this.patient_min_bp = patient_min_bp;
	}
	public int getPatient_pulse() {
		return patient_pulse;
	}
	public void setPatient_pulse(int patient_pulse) {
		this.patient_pulse = patient_pulse;
	}
	public double getPatient_height() {
		return patient_height;
	}
	public void setPatient_height(double patient_height) {
		this.patient_height = patient_height;
	}
	public double getPatient_weight() {
		return patient_weight;
	}
	public void setPatient_weight(double patient_weight) {
		this.patient_weight = patient_weight;
	}
	public String getPatient_guardian_name() {
		return patient_guardian_name;
	}
	public void setPatient_guardian_name(String patient_guardian_name) {
		this.patient_guardian_name = patient_guardian_name;
	}
	public String getPatient_guardian_phone() {
		return patient_guardian_phone;
	}
	public void setPatient_guardian_phone(String patient_guardian_phone) {
		this.patient_guardian_phone = patient_guardian_phone;
	}
	public String getPatient_guardian_relationship() {
		return patient_guardian_relationship;
	}
	public void setPatient_guardian_relationship(String patient_guardian_relationship) {
		this.patient_guardian_relationship = patient_guardian_relationship;
	}
	public String getPatient_register_date() {
		return patient_register_date;
	}
	public void setPatient_register_date(String patient_register_date) {
		this.patient_register_date = patient_register_date;
	}
	
	public String getFirstReceiptDate() {
		return firstReceiptDate;
	}
	public void setFirstReceiptDate(String firstReceiptDate) {
		this.firstReceiptDate = firstReceiptDate;
	}
	public String getLastReceiptDate() {
		return lastReceiptDate;
	}
	public void setLastReceiptDate(String lastReceiptDate) {
		this.lastReceiptDate = lastReceiptDate;
	}
	@Override
	public String toString() {
		return "Patients [patient_id=" + patient_id + ", patient_name=" + patient_name + ", patient_ssn=" + patient_ssn
				+ ", patient_sex=" + patient_sex + ", patient_phone=" + patient_phone + ", patient_zipcode="
				+ patient_zipcode + ", patient_address=" + patient_address + ", patient_detail_address="
				+ patient_detail_address + ", patient_blood_type=" + patient_blood_type + ", patient_max_bp="
				+ patient_max_bp + ", patient_min_bp=" + patient_min_bp + ", patient_pulse=" + patient_pulse
				+ ", patient_height=" + patient_height + ", patient_weight=" + patient_weight
				+ ", patient_guardian_name=" + patient_guardian_name + ", patient_guardian_phone="
				+ patient_guardian_phone + ", patient_guardian_relationship=" + patient_guardian_relationship
				+ ", patient_register_date=" + patient_register_date + ", firstReceiptDate=" + firstReceiptDate
				+ ", lastReceiptDate=" + lastReceiptDate + "]";
	}
	
	
}
