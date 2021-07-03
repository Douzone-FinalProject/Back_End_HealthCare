package com.mycompany.healthcare.dto;

public class DiagnosticLists {
	private int diagnostic_list_id;
	private String diagnostic_list_barcode;
	private String diagnostic_list_state;
	private String diagnostic_specimen_number;
	private int receipt_id;
	private int staff_id;
	private int search_id;
	
	public int getDiagnostic_list_id() {
		return diagnostic_list_id;
	}
	public void setDiagnostic_list_id(int diagnostic_list_id) {
		this.diagnostic_list_id = diagnostic_list_id;
	}
	public String getDiagnostic_list_barcode() {
		return diagnostic_list_barcode;
	}
	public void setDiagnostic_list_barcode(String diagnostic_list_barcode) {
		this.diagnostic_list_barcode = diagnostic_list_barcode;
	}
	public String getDiagnostic_list_state() {
		return diagnostic_list_state;
	}
	public void setDiagnostic_list_state(String diagnostic_list_state) {
		this.diagnostic_list_state = diagnostic_list_state;
	}
	public String getDiagnostic_specimen_number() {
		return diagnostic_specimen_number;
	}
	public void setDiagnostic_specimen_number(String diagnostic_specimen_number) {
		this.diagnostic_specimen_number = diagnostic_specimen_number;
	}
	public int getReceipt_id() {
		return receipt_id;
	}
	public void setReceipt_id(int receipt_id) {
		this.receipt_id = receipt_id;
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public int getSearch_id() {
		return search_id;
	}
	public void setSearch_id(int search_id) {
		this.search_id = search_id;
	}
	
	@Override
	public String toString() {
		return "DiagnosticLists [diagnostic_list_id=" + diagnostic_list_id + ", diagnostic_list_barcode="
				+ diagnostic_list_barcode + ", diagnostic_list_state=" + diagnostic_list_state
				+ ", diagnostic_specimen_number=" + diagnostic_specimen_number + ", receipt_id=" + receipt_id
				+ ", staff_id=" + staff_id + ", search_id=" + search_id + "]";
	}
}
