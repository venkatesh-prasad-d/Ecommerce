package com.StatusReportingTool.Bean;

import java.sql.Timestamp;

	/**
	 * ReportDateBean.java
	 * Purpose: Bean class.
	 *
	 * @author Venkatesh Prasad D
	 * @version 1.0 6/18/2017
	 */

public class ReportDateBean {
	int id;
	String emp_id;
	Timestamp startDate;
	Timestamp endDate;
	String dates;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}
	
	

}
