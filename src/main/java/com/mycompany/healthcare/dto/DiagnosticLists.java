package com.mycompany.healthcare.dto;

public class DiagnosticLists {
	private int diagnostic_list_id;
	private String diagnostic_list_barcode;
	private String diagnostic_list_state;
	private String diagnostic_specimen_number;
	private int receipt_id;
	private int staff_id;
	private int search_id;
	private String staff_name;
	private String diagnostic_result_state;
	private String doctor_name;
//	private Searchs searchs;
//	private String sympton_id;
//	private Bundles bundles;
	
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
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getDiagnostic_result_state() {
		return diagnostic_result_state;
	}
	public void setDiagnostic_result_state(String diagnostic_result_state) {
		this.diagnostic_result_state = diagnostic_result_state;
	}
	
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	
	//	public String getSympton_id() {
//		return sympton_id;
//	}
//	public void setSympton_id(String sympton_id) {
//		this.sympton_id = sympton_id;
//	}
//	public Bundles getBundles() {
//		return bundles;
//	}
//	public void setBundles(Bundles bundles) {
//		this.bundles = bundles;
//	}
//	
//	public Searchs getSearchs() {
//		return searchs;
//	}
//	public void setSearchs(Searchs searchs) {
//		this.searchs = searchs;
//	}
	@Override
	public String toString() {
		return "DiagnosticLists [diagnostic_list_id=" + diagnostic_list_id + ", diagnostic_list_barcode="
				+ diagnostic_list_barcode + ", diagnostic_list_state=" + diagnostic_list_state
				+ ", diagnostic_specimen_number=" + diagnostic_specimen_number + ", receipt_id=" + receipt_id
				+ ", staff_id=" + staff_id + ", search_id=" + search_id + ", staff_name=" + staff_name
				+ ", diagnostic_result_state=" + diagnostic_result_state + ", doctor_name=" + doctor_name + "]";
	}
	
}
