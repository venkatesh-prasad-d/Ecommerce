package com.StatusReportingTool.Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.StatusReportingTool.Bean.ReportBean;
import com.StatusReportingTool.DAO.ReportDAO;
import com.opensymphony.xwork2.ActionSupport;
	/**
	 * LoginAction.java
	 * Purpose: Validation Of the user.
	 *
	 * @author Venkatesh Prasad D
	 * @version 1.0 6/18/2017
	 */
public class ReportAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	ReportBean reportbean = new ReportBean();
	ReportDAO report = new ReportDAO();
	private String startdate;
	private String enddate;
	
	/**
	 * Validates the input form fields
	 *
	 * @return Error.
	 */
	
	public void validate(){
		if(StringUtils.isEmpty(startdate)){
			addFieldError("startDate", "Please Enter Start Date");			
		}
		if(StringUtils.isEmpty(enddate)){
			addFieldError("endDate", "Please Enter END Date");
		}
		
		if(StringUtils.isNotEmpty(startdate) && StringUtils.isNotEmpty(enddate) ){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate;
			Date endDate;
			try {
				startDate = (Date) sdf.parse(startdate);
				endDate = (Date) sdf.parse(enddate);
				if(endDate.before(startDate)){ // Checking whether start date is after end date
					addFieldError("startDate", "Start Date should be before end date");
				}else if((endDate.getDate()-startDate.getDate())>7){ // Checking whether difference between start and end date is more than a week
					addFieldError("endDate", "End Date should be within a week");
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		if(StringUtils.isEmpty(reportbean.getTaskCompleted())){
			addFieldError("taskCompleted", "Task Completed Cant be empty ");
		}
		if(StringUtils.isEmpty(reportbean.getTaskNW())){
			addFieldError("taskNW", "Task Ccmpleted Cant be empty ");
		}
		
	}

	/**
	 * Convert form data into text file and uploading
	 *
	 * @return String.
	 * @throws IOException,ParseException,SQLException
	 */

	public String execute() throws IOException, ParseException, SQLException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date startDate = (Date) sdf.parse(startdate); //converting string to date
		Date endDate = (Date) sdf.parse(enddate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		
		Timestamp sdate = new Timestamp(startDate.getTime()); // converting startdate and enddate to SQL compatable format
		cal.setTime(endDate);
		 endDate = cal.getTime();
		Timestamp edate = new Timestamp(endDate.getTime());		
		
		reportbean.setsDate(sdate);		
		reportbean.seteDate(edate);
		
		/*Writing User entered details into text file*/
		String location = System.getProperty("user.home")+"\\Documents\\Reports\\WeeklyReport_"+sdf.format(cal.getTime())+".txt"; // writing user input to .txt file
		File reportFile = new File(location);
		FileWriter writer = new FileWriter(reportFile);
		
		writer.write("Employee ID : "+reportbean.getEmp_id()+System.lineSeparator());
		writer.write("Employee Name : "+reportbean.getEmp_name()+System.lineSeparator());
		writer.write("1st Day of the Week : "+reportbean.getsDate().toString()+System.lineSeparator());
		writer.write("Last Day of the Week : "+reportbean.geteDate().toString()+System.lineSeparator());
		writer.write("Target Achieved : "+reportbean.getTaskCompleted()+System.lineSeparator());
		writer.write("Target for next WEEK : "+reportbean.getTaskNW()+System.lineSeparator());
		writer.write("Issues Faced : "+reportbean.getIssues()+System.lineSeparator());
		writer.close();
		
		reportbean.setTxtFile(readBytesFromFile(location));
		report.addReport(reportbean);
		addActionMessage("Report added succefully");
		return "success";
		
	}
	/**
	 * Reading input text file
	 *
	 * @return bytes[].
	 * @throws IOException
	 */
    private static byte[] readBytesFromFile(String filePath) throws IOException {
        File inputFile = new File(filePath);
        FileInputStream inputStream = new FileInputStream(inputFile);
         
        byte[] fileBytes = new byte[(int) inputFile.length()];
        inputStream.read(fileBytes);
        
        inputStream.close();
         
        return fileBytes;
    	}
    
		/**
		 * Getters and setters for bean 
		 */

	public String getStartdate() {
		return startdate;
		}

	public String getEnddate() {
		return enddate;
		}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
		}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
		}


	public ReportBean getReportbean() {
		return reportbean;
	}

	public void setReportbean(ReportBean reportbean) {
		this.reportbean = reportbean;
	}

}
