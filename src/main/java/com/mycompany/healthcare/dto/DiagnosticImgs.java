package com.mycompany.healthcare.dto;

public class DiagnosticImgs {
	private int diagnostic_img_id;
	private String diagnostic_attachtype;
	private String diagnostic_attachoname;
	private String diagnostic_attachsname;
	private int receipt_id;
	
	public int getDiagnostic_img_id() {
		return diagnostic_img_id;
	}
	public void setDiagnostic_img_id(int diagnostic_img_id) {
		this.diagnostic_img_id = diagnostic_img_id;
	}
	public String getDiagnostic_attachtype() {
		return diagnostic_attachtype;
	}
	public void setDiagnostic_attachtype(String diagnostic_attachtype) {
		this.diagnostic_attachtype = diagnostic_attachtype;
	}
	public String getDiagnostic_attachoname() {
		return diagnostic_attachoname;
	}
	public void setDiagnostic_attachoname(String diagnostic_attachoname) {
		this.diagnostic_attachoname = diagnostic_attachoname;
	}
	public String getDiagnostic_attachsname() {
		return diagnostic_attachsname;
	}
	public void setDiagnostic_attachsname(String diagnostic_attachsname) {
		this.diagnostic_attachsname = diagnostic_attachsname;
	}
	public int getReceipt_id() {
		return receipt_id;
	}
	public void setReceipt_id(int receipt_id) {
		this.receipt_id = receipt_id;
	}
	
	@Override
	public String toString() {
		return "DiagnosticImgs [diagnostic_img_id=" + diagnostic_img_id + ", diagnostic_attachtype="
				+ diagnostic_attachtype + ", diagnostic_attachoname=" + diagnostic_attachoname
				+ ", diagnostic_attachsname=" + diagnostic_attachsname + ", receipt_id=" + receipt_id + "]";
	}
}
