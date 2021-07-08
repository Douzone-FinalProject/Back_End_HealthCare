package com.mycompany.healthcare.dto;

public class Medicines {
	private String medicine_id;
	private String medicine_name;
	private String medicine_type;
	private String medicine_unit;
	private String quantity;
	
	public String getMedicine_id() {
		return medicine_id;
	}
	public void setMedicine_id(String medicine_id) {
		this.medicine_id = medicine_id;
	}
	public String getMedicine_name() {
		return medicine_name;
	}
	public void setMedicine_name(String medicine_name) {
		this.medicine_name = medicine_name;
	}
	public String getMedicine_type() {
		return medicine_type;
	}
	public void setMedicine_type(String medicine_type) {
		this.medicine_type = medicine_type;
	}
	public String getMedicine_unit() {
		return medicine_unit;
	}
	public void setMedicine_unit(String medicine_unit) {
		this.medicine_unit = medicine_unit;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Medicines [medicine_id=" + medicine_id + ", medicine_name=" + medicine_name + ", medicine_type="
				+ medicine_type + ", medicine_unit=" + medicine_unit + ", quantity=" + quantity + "]";
	}
	
	
	
	
	
	
}
