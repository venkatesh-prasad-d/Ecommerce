package com.StatusReportingTool.Action;

import java.io.IOException;
import java.sql.SQLException;


import java.text.SimpleDateFormat;

import com.StatusReportingTool.Bean.ViewReportBean;
import com.StatusReportingTool.DAO.ViewReportDAO;
/**
 * ViewReportAction.java
 * Purpose: Getting Report for the user.
 *
 * @author Venkatesh Prasad D
 * @version 1.0 6/18/2017
 */
public class ViewReportAction {
	ViewReportBean viewBean = new ViewReportBean();
	ViewReportDAO viewDAO = new ViewReportDAO();
	String convertedDate;
	
	/**
	 * Getting the report for user for selected date
	 *
	 * @return String.
	 */
	public String execute() throws SQLException, IOException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");		
		viewBean = viewDAO.getReport(viewBean);
		convertedDate = sdf.format(viewBean.getStartDate())+" To "+sdf.format(viewBean.getEndDate());
		viewBean.setWeek(convertedDate);
		return "success";
		
	}
	/**
	 * Getters and setters for bean 
	 */
	public ViewReportBean getViewBean() {
		return viewBean;
	}
	public void setViewBean(ViewReportBean viewBean) {
		this.viewBean = viewBean;
	}

}
