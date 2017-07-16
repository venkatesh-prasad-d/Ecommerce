package com.nephrology.action;

import java.util.ArrayList;

import com.nephrology.DAO.PatientDAO;
import com.nephrology.bean.PatientBean;

public class PatientAction {
	PatientBean patientbean = new PatientBean();
	PatientDAO patientDAO = new PatientDAO();
	Boolean valid = false;
	ArrayList<PatientBean> patientlist = new ArrayList<PatientBean>();
	public String execute(){
		patientbean.setDoc_id("1asd2");
		patientlist = patientDAO.getPatients(patientbean);
		return "success";
		
	}
	public PatientBean getPatientbean() {
		return patientbean;
	}
	public void setPatientbean(PatientBean patientbean) {
		this.patientbean = patientbean;
	}
	public ArrayList<PatientBean> getPatientlist() {
		return patientlist;
	}
	public void setPatientlist(ArrayList<PatientBean> patientlist) {
		this.patientlist = patientlist;
	}
}
