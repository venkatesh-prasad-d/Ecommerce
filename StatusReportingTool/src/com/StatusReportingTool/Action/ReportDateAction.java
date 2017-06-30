package com.StatusReportingTool.Action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.StatusReportingTool.Bean.ReportDateBean;
import com.StatusReportingTool.DAO.ReportDateDAO;

	/**
	 * ReportDateAction.java
	 * Purpose: Getting Report Date for the user.
	 *
	 * @author Venkatesh Prasad D
	 * @version 1.0 6/18/2017
	 */
public class ReportDateAction {
	ReportDateBean dateBean = new ReportDateBean();
	ReportDateDAO dateDAO = new ReportDateDAO();
	ArrayList<ReportDateBean> dateList = new ArrayList<ReportDateBean>();
	ArrayList<String> dates = new ArrayList<String>();
	String convertedDate;
	
	/**
	 * Selecting dates for which the user has uploaded the report
	 *
	 * @return String.
	 */
	
	public String execute(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		dateList = dateDAO.getDates(dateBean);
		for(int i =0; i < dateList.size(); i++){ // converting the SQL date into String date range
			convertedDate = sdf.format(dateList.get(i).getStartDate())+" To "+sdf.format(dateList.get(i).getEndDate());
			dateList.get(i).setDates(convertedDate);	
					}
		
		return "success";
		
	}
	/**
	 * Getters and setters for bean 
	 */
	public ReportDateBean getDateBean() {
		return dateBean;
	}

	public void setDateBean(ReportDateBean dateBean) {
		this.dateBean = dateBean;
	}

	public ArrayList<ReportDateBean> getDateList() {
		return dateList;
	}

	public void setDateList(ArrayList<ReportDateBean> dateList) {
		this.dateList = dateList;
	}

}
