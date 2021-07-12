package com.mycompany.healthcare.dto;

public class DiagnosticImgs {
	private int diagnostic_img_id;
//	private String diagnostic_attachtype;
//	private String diagnostic_attachoname;
//	private String diagnostic_attachsname;
	private int receipt_id;
	private String diagnostic_img;
	private String img_type;
	
	public int getDiagnostic_img_id() {
		return diagnostic_img_id;
	}
	public void setDiagnostic_img_id(int diagnostic_img_id) {
		this.diagnostic_img_id = diagnostic_img_id;
	}
	public int getReceipt_id() {
		return receipt_id;
	}
	public void setReceipt_id(int receipt_id) {
		this.receipt_id = receipt_id;
	}
	public String getDiagnostic_img() {
		return diagnostic_img;
	}
	public void setDiagnostic_img(String diagnostic_img) {
		this.diagnostic_img = diagnostic_img;
	}
	public String getImg_type() {
		return img_type;
	}
	public void setImg_type(String img_type) {
		this.img_type = img_type;
	}
	
	
//	@Override
//	public String toString() {
//		return "DiagnosticImgs [diagnostic_img_id=" + diagnostic_img_id + ", diagnostic_attachtype="
//				+ diagnostic_attachtype + ", diagnostic_attachoname=" + diagnostic_attachoname
//				+ ", diagnostic_attachsname=" + diagnostic_attachsname + ", receipt_id=" + receipt_id + "]";
//	}
}
