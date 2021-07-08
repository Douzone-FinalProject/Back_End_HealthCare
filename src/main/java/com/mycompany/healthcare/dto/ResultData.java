package com.mycompany.healthcare.dto;

public class ResultData {
	private int diagnostic_results_id;
	private String diagnostic_result;
	private String diagnostic_date;
	private String diagnostic_previous_result;
	private String diagnostic_previous_date;
	private int diagnostic_list_id;
	private String prescription_name;
	private String prescription_reference_value;
	private String prescription_unit;
	private String diagnostic_specimen_number;
	private int search_id;
	private String symptom_name;
	private String bundle_id;
	private String bundle_specimen;
	private String prescription_id;
	private int receipt_id;
	
	public int getReceipt_id() {
		return receipt_id;
	}
	public void setReceipt_id(int receipt_id) {
		this.receipt_id = receipt_id;
	}
	public int getDiagnostic_results_id() {
		return diagnostic_results_id;
	}
	public void setDiagnostic_results_id(int diagnostic_results_id) {
		this.diagnostic_results_id = diagnostic_results_id;
	}
	public String getDiagnostic_result() {
		return diagnostic_result;
	}
	public void setDiagnostic_result(String diagnostic_result) {
		this.diagnostic_result = diagnostic_result;
	}
	public String getDiagnostic_date() {
		return diagnostic_date;
	}
	public void setDiagnostic_date(String diagnostic_date) {
		this.diagnostic_date = diagnostic_date;
	}
	public String getDiagnostic_previous_result() {
		return diagnostic_previous_result;
	}
	public void setDiagnostic_previous_result(String diagnostic_previous_result) {
		this.diagnostic_previous_result = diagnostic_previous_result;
	}
	public String getDiagnostic_previous_date() {
		return diagnostic_previous_date;
	}
	public void setDiagnostic_previous_date(String diagnostic_previous_date) {
		this.diagnostic_previous_date = diagnostic_previous_date;
	}
	public int getDiagnostic_list_id() {
		return diagnostic_list_id;
	}
	public void setDiagnostic_list_id(int diagnostic_list_id) {
		this.diagnostic_list_id = diagnostic_list_id;
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
	public String getDiagnostic_specimen_number() {
		return diagnostic_specimen_number;
	}
	public void setDiagnostic_specimen_number(String diagnostic_specimen_number) {
		this.diagnostic_specimen_number = diagnostic_specimen_number;
	}
	public int getSearch_id() {
		return search_id;
	}
	public void setSearch_id(int search_id) {
		this.search_id = search_id;
	}
	public String getSymptom_name() {
		return symptom_name;
	}
	public void setSymptom_name(String symptom_name) {
		this.symptom_name = symptom_name;
	}
	public String getBundle_id() {
		return bundle_id;
	}
	public void setBundle_id(String bundle_id) {
		this.bundle_id = bundle_id;
	}
	public String getBundle_specimen() {
		return bundle_specimen;
	}
	public void setBundle_specimen(String bundle_specimen) {
		this.bundle_specimen = bundle_specimen;
	}
	public String getPrescription_id() {
		return prescription_id;
	}
	public void setPrescription_id(String prescription_id) {
		this.prescription_id = prescription_id;
	}
	@Override
	public String toString() {
		return "ResultData [diagnostic_results_id=" + diagnostic_results_id + ", diagnostic_result=" + diagnostic_result
				+ ", diagnostic_date=" + diagnostic_date + ", diagnostic_previous_result=" + diagnostic_previous_result
				+ ", diagnostic_previous_date=" + diagnostic_previous_date + ", diagnostic_list_id="
				+ diagnostic_list_id + ", prescription_name=" + prescription_name + ", prescription_reference_value="
				+ prescription_reference_value + ", prescription_unit=" + prescription_unit
				+ ", diagnostic_specimen_number=" + diagnostic_specimen_number + ", search_id=" + search_id
				+ ", symptom_name=" + symptom_name + ", bundle_id=" + bundle_id + ", bundle_specimen=" + bundle_specimen
				+ ", prescription_id=" + prescription_id + "]";
	}
	
}
