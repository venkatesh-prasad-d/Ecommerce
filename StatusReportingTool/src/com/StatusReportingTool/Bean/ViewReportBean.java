package com.StatusReportingTool.Bean;

import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;
	/**
	 * ViewReportBean.java
	 * Purpose: Bean class.
	 *
	 * @author Venkatesh Prasad D
	 * @version 1.0 6/18/2017
	 */
public class ViewReportBean {
	
	int id;
	String week;
	String emp_id;
	Blob txtFile;
	Timestamp startDate;
	Timestamp endDate;
	String fileData;
	
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	public String getFileData() {
		return fileData;
	}
	public void setFileData(String fileData) {
		this.fileData = fileData;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public Blob getTxtFile() {
		return txtFile;
	}
	public void setTxtFile(Blob txtFile) throws SQLException {
		byte[] blobBytes = txtFile.getBytes(1, (int) txtFile.length()); //Converts blob data to string and sets to bean
		String s = new String(blobBytes);		
		setFileData(s);
		this.txtFile = txtFile;
	}

}
