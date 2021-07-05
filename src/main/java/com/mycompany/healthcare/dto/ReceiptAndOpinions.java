package com.mycompany.healthcare.dto;

public class ReceiptAndOpinions {
	private int receipt_id;
	private String receipt_datetime;
	private String receipt_state;
	private String diagnostic_test_state;
	private String receipt_opinion;
	private String receipt_uniqueness;
	private int patient_id;
	/* 1:1  */
	private String patient_name;
	private String patient_sex;
	private String patient_phone;

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
	public String getReceipt_state() {
		return receipt_state;
	}
	public void setReceipt_state(String receipt_state) {
		this.receipt_state = receipt_state;
	}
	public String getDiagnostic_test_state() {
		return diagnostic_test_state;
	}
	public void setDiagnostic_test_state(String diagnostic_test_state) {
		this.diagnostic_test_state = diagnostic_test_state;
	}
	public String getReceipt_opinion() {
		return receipt_opinion;
	}
	public void setReceipt_opinion(String receipt_opinion) {
		this.receipt_opinion = receipt_opinion;
	}
	public String getReceipt_uniqueness() {
		return receipt_uniqueness;
	}
	public void setReceipt_uniqueness(String receipt_uniqueness) {
		this.receipt_uniqueness = receipt_uniqueness;
	}
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
	@Override
	public String toString() {
		return "ReceiptAndOpinions [receipt_id=" + receipt_id + ", receipt_datetime=" + receipt_datetime
				+ ", receipt_state=" + receipt_state + ", diagnostic_test_state=" + diagnostic_test_state
				+ ", receipt_opinion=" + receipt_opinion + ", receipt_uniqueness=" + receipt_uniqueness
				+ ", patient_id=" + patient_id + ", patient_name=" + patient_name + ", patient_sex=" + patient_sex
				+ ", patient_phone=" + patient_phone + "]";
	}
	
	
	
}
