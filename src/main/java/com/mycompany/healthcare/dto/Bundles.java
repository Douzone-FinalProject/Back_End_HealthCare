package com.mycompany.healthcare.dto;

public class Bundles {
	private String bundle_id;
	private String bundle_name;
	private String bundle_specimen;
	private String bundle_bottle;
	private String bundle_lab;
	
	public String getBundle_id() {
		return bundle_id;
	}
	public void setBundle_id(String bundle_id) {
		this.bundle_id = bundle_id;
	}
	public String getBundle_name() {
		return bundle_name;
	}
	public void setBundle_name(String bundle_name) {
		this.bundle_name = bundle_name;
	}
	public String getBundle_specimen() {
		return bundle_specimen;
	}
	public void setBundle_specimen(String bundle_specimen) {
		this.bundle_specimen = bundle_specimen;
	}
	public String getBundle_bottle() {
		return bundle_bottle;
	}
	public void setBundle_bottle(String bundle_bottle) {
		this.bundle_bottle = bundle_bottle;
	}
	public String getBundle_lab() {
		return bundle_lab;
	}
	public void setBundle_lab(String bundle_lab) {
		this.bundle_lab = bundle_lab;
	}
	
	@Override
	public String toString() {
		return "bundles [bundle_id=" + bundle_id + ", bundle_name=" + bundle_name + ", bundle_specimen="
				+ bundle_specimen + ", bundle_bottle=" + bundle_bottle + ", bundle_lab=" + bundle_lab + "]";
	}
}
