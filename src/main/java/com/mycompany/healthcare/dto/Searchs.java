package com.mycompany.healthcare.dto;

public class Searchs {
	private int search_id;
	private String symptom_id;
	private String symptom_name;
	private String bundle_name;
	private String bundle_id;
	public int getSearch_id() {
		return search_id;
	}
	public void setSearch_id(int search_id) {
		this.search_id = search_id;
	}
	public String getSymptom_id() {
		return symptom_id;
	}
	public void setSymptom_id(String symptom_id) {
		this.symptom_id = symptom_id;
	}
	public String getSymptom_name() {
		return symptom_name;
	}
	public void setSymptom_name(String symptom_name) {
		this.symptom_name = symptom_name;
	}
	public String getBundle_name() {
		return bundle_name;
	}
	public void setBundle_name(String bundle_name) {
		this.bundle_name = bundle_name;
	}
	public String getBundle_id() {
		return bundle_id;
	}
	public void setBundle_id(String bundle_id) {
		this.bundle_id = bundle_id;
	}
	@Override
	public String toString() {
		return "Searchs [search_id=" + search_id + ", symptom_id=" + symptom_id + ", symptom_name=" + symptom_name
				+ ", bundle_name=" + bundle_name + ", bundle_id=" + bundle_id + "]";
	}
	
	
	
}
