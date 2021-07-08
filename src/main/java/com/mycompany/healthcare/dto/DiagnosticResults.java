package com.mycompany.healthcare.dto;

import java.util.Date;

public class DiagnosticResults {
	private int diagnostic_results_id;
	private String diagnostic_result;
	private String diagnostic_date;
	private String diagnostic_previous_result;
	private String diagnostic_previous_date;
	private int diagnostic_list_id;
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
	@Override
	public String toString() {
		return "DiagnosticResults [diagnostic_results_id=" + diagnostic_results_id + ", diagnostic_result="
				+ diagnostic_result + ", diagnostic_date=" + diagnostic_date + ", diagnostic_previous_result="
				+ diagnostic_previous_result + ", diagnostic_previous_date=" + diagnostic_previous_date
				+ ", diagnostic_list_id=" + diagnostic_list_id + "]";
	}
	
	
	
}
