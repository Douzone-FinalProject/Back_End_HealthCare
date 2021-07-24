package com.mycompany.healthcare.dto;

import java.util.List;
import java.util.Map;

public class SaveImgs {
	private int receiptId;
//	private String type;
	private String filename;
	private List<Map<String, String>> base64;
	
	
	public int getReceiptId() {
		return receiptId;
	}
	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}
//	public String getType() {
//		return type;
//	}
//	public void setType(String type) {
//		this.type = type;
//	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public List<Map<String, String>> getBase64() {
		return base64;
	}
	public void setBase64(List<Map<String, String>> base64) {
		this.base64 = base64;
	}

}
