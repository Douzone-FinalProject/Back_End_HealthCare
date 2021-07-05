package com.mycompany.healthcare.dto;

import java.util.Date;

public class Messages {
	private int message_id;
	private String message_content;
	private String staff_login_id;
	private String message_date;
	private int staff_id;
	private String message_sender;
	
	public int getMessage_id() {
		return message_id;
	}
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	public String getMessage_content() {
		return message_content;
	}
	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}
	public String getStaff_login_id() {
		return staff_login_id;
	}
	public void setStaff_login_id(String staff_login_id) {
		this.staff_login_id = staff_login_id;
	}
	public String getMessage_date() {
		return message_date;
	}
	public void setMessage_date(String message_date) {
		this.message_date = message_date;
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public String getMessage_sender() {
		return message_sender;
	}
	public void setMessage_sender(String message_sender) {
		this.message_sender = message_sender;
	}
	
	@Override
	public String toString() {
		return "Messages [message_id=" + message_id + ", message_content=" + message_content + ", staff_login_id="
				+ staff_login_id + ", message_date=" + message_date + ", staff_id=" + staff_id + ", message_sender="
				+ message_sender + "]";
	}
}
