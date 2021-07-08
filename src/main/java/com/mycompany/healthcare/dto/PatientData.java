package com.mycompany.healthcare.dto;

import java.util.Date;

public class PatientData {
	private int receipt_id;
	private String receipt_datetime;
	private String patient_name;
	private String symptom_name;
	private String patient_sex;
	private String ssn;
	private String blood_datetime;
	
	public int getReceipt_id() {
		return receipt_id;
	}
	public void setReceipt_id(int receipt_id) {
		this.receipt_id = receipt_id;
	}
	public String getReceipt_datetime() {
		return receipt_datetime;
	}
	public void setReceipt_datetime(String receipt_datetime) {
		this.receipt_datetime = receipt_datetime;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public String getSymptom_name() {
		return symptom_name;
	}
	public void setSymptom_name(String symptom_name) {
		this.symptom_name = symptom_name;
	}
	public String getPatient_sex() {
		return patient_sex;
	}
	public void setPatient_sex(String patient_sex) {
		this.patient_sex = patient_sex;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getBlood_datetime() {
		return blood_datetime;
	}
	public void setBlood_datetime(String blood_datetime) {
		this.blood_datetime = blood_datetime;
	}
	
	@Override
	public String toString() {
		return "PatientData [receipt_id=" + receipt_id + ", receipt_datetime=" + receipt_datetime + ", patient_name="
				+ patient_name + ", symptom_name=" + symptom_name + ", patient_sex=" + patient_sex + ", ssn=" + ssn
				+ ", blood_datetime=" + blood_datetime + "]";
	}
}
