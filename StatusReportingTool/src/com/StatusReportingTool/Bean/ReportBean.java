package com.StatusReportingTool.Bean;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;

	/**
	 * ReportBean.java
	 * Purpose: Bean class.
	 *
	 * @author Venkatesh Prasad D
	 * @version 1.0 6/18/2017
	 */

public class ReportBean {
	public String emp_id;
	public String emp_name;
	Timestamp sDate;
	Timestamp eDate;
	public String taskCompleted;
	public String taskNW;
	public String issues;
	private byte[] txtFile;
	private Blob file;
	int id;



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Blob getFile() {
		return file;
	}

	public void setFile(Blob file) {
		this.file = file;
	}

	public byte[] getTxtFile() {
		return txtFile;
	}

	public void setTxtFile(byte[] txtFile) {
		this.txtFile = txtFile;
	}

	public String getEmp_id() {
		return emp_id;
	}
	
	public Timestamp getsDate() {
		return sDate;
	}

	public void setsDate(Timestamp sDate) {
		this.sDate = sDate;
	}

	public Timestamp geteDate() {
		return eDate;
	}

	public void seteDate(Timestamp eDate) {
		this.eDate = eDate;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	
	public String getTaskCompleted() {
		return taskCompleted;
	}
	public void setTaskCompleted(String taskCompleted) {
		this.taskCompleted = taskCompleted;
	}
	public String getTaskNW() {
		return taskNW;
	}
	public void setTaskNW(String taskNW) {
		this.taskNW = taskNW;
	}
	public String getIssues() {
		return issues;
	}
	public void setIssues(String issues) {
		this.issues = issues;
	}
	
}
