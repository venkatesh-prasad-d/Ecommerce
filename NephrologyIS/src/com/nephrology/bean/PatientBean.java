package com.nephrology.bean;

public class PatientBean {
	String doc_id;
	String patientId;
	String patientName;
	String patientSex;
	int patientAge;
	public String getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientid) {
		this.patientId = patientid;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientSex() {
		return patientSex;
	}
	public void setPatientSex(String patientSex) {
		this.patientSex = patientSex;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientage) {
		this.patientAge = patientage;
	}

}
