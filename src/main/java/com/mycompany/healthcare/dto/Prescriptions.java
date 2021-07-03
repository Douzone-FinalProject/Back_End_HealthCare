package com.mycompany.healthcare.dto;

public class Prescriptions {
	private String prescription_id;
	private String prescription_name;
	private String prescription_reference_value;
	private String prescription_unit;
	private String bundle_id;
	public String getPrescription_id() {
		return prescription_id;
	}
	public void setPrescription_id(String prescription_id) {
		this.prescription_id = prescription_id;
	}
	public String getPrescription_name() {
		return prescription_name;
	}
	public void setPrescription_name(String prescription_name) {
		this.prescription_name = prescription_name;
	}
	public String getPrescription_reference_value() {
		return prescription_reference_value;
	}
	public void setPrescription_reference_value(String prescription_reference_value) {
		this.prescription_reference_value = prescription_reference_value;
	}
	public String getPrescription_unit() {
		return prescription_unit;
	}
	public void setPrescription_unit(String prescription_unit) {
		this.prescription_unit = prescription_unit;
	}
	public String getBundle_id() {
		return bundle_id;
	}
	public void setBundle_id(String bundle_id) {
		this.bundle_id = bundle_id;
	}
	@Override
	public String toString() {
		return "Prescriptions [prescription_id=" + prescription_id + ", prescription_name=" + prescription_name
				+ ", prescription_reference_value=" + prescription_reference_value + ", prescription_unit="
				+ prescription_unit + ", bundle_id=" + bundle_id + "]";
	}
	
	
	
	
}
