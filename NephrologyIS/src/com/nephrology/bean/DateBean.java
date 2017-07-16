package com.nephrology.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
public class DateBean {
	int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	String patientid;
	String doc_id;
	String patientName;
	String docName;
	Date date;
	String dateList1;

	

	

	public String getDateList1() {
		return dateList1;
	}

	public void setDateList1(String dateList1) {
		this.dateList1 = dateList1;
	}

	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		setDateList1(sdf.format(date));
		this.date = date;
	}

	public String getPatientid() {
		return patientid;
	}

	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}

	

}
