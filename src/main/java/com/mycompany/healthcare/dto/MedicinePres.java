package com.mycompany.healthcare.dto;

public class MedicinePres {
	private int medicine_pre_id;
	private String medicine_pre_quantity;
	private int receipt_id;
	private String medicine_id;
	public int getMedicine_pre_id() {
		return medicine_pre_id;
	}
	public void setMedicine_pre_id(int medicine_pre_id) {
		this.medicine_pre_id = medicine_pre_id;
	}
	public String getMedicine_pre_quantity() {
		return medicine_pre_quantity;
	}
	public void setMedicine_pre_quantity(String medicine_pre_quantity) {
		this.medicine_pre_quantity = medicine_pre_quantity;
	}
	public int getReceipt_id() {
		return receipt_id;
	}
	public void setReceipt_id(int receipt_id) {
		this.receipt_id = receipt_id;
	}
	public String getMedicine_id() {
		return medicine_id;
	}
	public void setMedicine_id(String medicine_id) {
		this.medicine_id = medicine_id;
	}
	@Override
	public String toString() {
		return "MedicinePres [medicine_pre_id=" + medicine_pre_id + ", medicine_pre_quantity=" + medicine_pre_quantity
				+ ", receipt_id=" + receipt_id + ", medicine_id=" + medicine_id + "]";
	}
	
	
	
}
