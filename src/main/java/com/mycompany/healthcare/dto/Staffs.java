package com.mycompany.healthcare.dto;

public class Staffs {
	private int staff_id;
	private String staff_name;
	private String staff_phone;
	private String staff_login_id;
	private String staff_login_pwd;
	private String staff_role;
	private int staff_enabled;
	private int hospital_id;
	private String hospital_name;
	
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getStaff_phone() {
		return staff_phone;
	}
	public void setStaff_phone(String staff_phone) {
		this.staff_phone = staff_phone;
	}
	public String getStaff_login_id() {
		return staff_login_id;
	}
	public void setStaff_login_id(String staff_login_id) {
		this.staff_login_id = staff_login_id;
	}
	public String getStaff_login_pwd() {
		return staff_login_pwd;
	}
	public void setStaff_login_pwd(String staff_login_pwd) {
		this.staff_login_pwd = staff_login_pwd;
	}
	public String getStaff_role() {
		return staff_role;
	}
	public void setStaff_role(String staff_role) {
		this.staff_role = staff_role;
	}
	public int getStaff_enabled() {
		return staff_enabled;
	}
	public void setStaff_enabled(int staff_enabled) {
		this.staff_enabled = staff_enabled;
	}
	public int getHospital_id() {
		return hospital_id;
	}
	public void setHospital_id(int hospital_id) {
		this.hospital_id = hospital_id;
	}
	public String getHospital_name() {
		return hospital_name;
	}
	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}
	@Override
	public String toString() {
		return "Staffs [staff_id=" + staff_id + ", staff_name=" + staff_name + ", staff_phone=" + staff_phone
				+ ", staff_login_id=" + staff_login_id + ", staff_login_pwd=" + staff_login_pwd + ", staff_role="
				+ staff_role + ", staff_enabled=" + staff_enabled + ", hospital_id=" + hospital_id + ", hospital_name="
				+ hospital_name + "]";
	}
	
}
