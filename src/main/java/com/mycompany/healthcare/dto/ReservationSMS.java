package com.mycompany.healthcare.dto;

public class ReservationSMS {
	private String name;
	private String phone;
	private String content;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "ReservationSMS [name=" + name + ", phone=" + phone + ", content=" + content + "]";
	}
	

}
