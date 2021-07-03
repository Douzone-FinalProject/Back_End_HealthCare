package com.mycompany.healthcare.dto;

public class Hospitals {
	private int hospital_id;
	private String hospital_name;
	private String hospital_address;
	private String hospital_tel;
	public int getHospital_id() {
		return hospital_id;
	}
	public void setHospital_id(int hospital_id) {
		this.hospital_id = hospital_id;
	}
	public String getHospital_name() {
		return hospital_name;
	}
	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}
	public String getHospital_address() {
		return hospital_address;
	}
	public void setHospital_address(String hospital_address) {
		this.hospital_address = hospital_address;
	}
	public String getHospital_tel() {
		return hospital_tel;
	}
	public void setHospital_tel(String hospital_tel) {
		this.hospital_tel = hospital_tel;
	}
	@Override
	public String toString() {
		return "Hospitals [hospital_id=" + hospital_id + ", hospital_name=" + hospital_name + ", hospital_address="
				+ hospital_address + ", hospital_tel=" + hospital_tel + "]";
	}
	
	
	
}
