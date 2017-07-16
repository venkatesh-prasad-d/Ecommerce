package com.nephrology.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class SearchBean {
	
	String date;
	Timestamp sqlDate;
	String patientId;
	String machineId;
	int T1;
	int T2;
	int T3;
	int T4;
	int T5;
	int bflow;
	int arterialpressure;
	int bolus;
	String status;
	int id;
	public Timestamp getSqlDate() {
		return sqlDate;
	}

	public void setSqlDate(Timestamp sqlDate) {
		this.sqlDate = sqlDate;
	}
	
	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getMachineId() {
		return machineId;
	}

	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}

	public int getT1() {
		return T1;
	}

	public void setT1(int t1) {
		T1 = t1;
	}

	public int getT2() {
		return T2;
	}

	public void setT2(int t2) {
		T2 = t2;
	}

	public int getT3() {
		return T3;
	}

	public void setT3(int t3) {
		T3 = t3;
	}

	public int getT4() {
		return T4;
	}

	public void setT4(int t4) {
		T4 = t4;
	}

	public int getT5() {
		return T5;
	}

	public void setT5(int t5) {
		T5 = t5;
	}

	public int getBflow() {
		return bflow;
	}

	public void setBflow(int bflow) {
		this.bflow = bflow;
	}

	public int getArterialpressure() {
		return arterialpressure;
	}

	public void setArterialpressure(int arterialpressure) {
		this.arterialpressure = arterialpressure;
	}

	public int getBolus() {
		return bolus;
	}

	public void setBolus(int bolus) {
		this.bolus = bolus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
