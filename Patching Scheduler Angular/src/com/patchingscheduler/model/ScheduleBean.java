package com.patchingscheduler.model;

import java.util.Date;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
@JsonAutoDetect
public class ScheduleBean {
	private String servers;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	private Date startDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	private Date endDate;
	private String blackDates;
	HashMap<Integer,Date> dtq_dateList = new HashMap<Integer, Date>();
	HashMap<Integer,Date> prod_dateList = new HashMap<Integer, Date>();	
	HashMap<Integer,Date> winDtq = new HashMap<Integer, Date>();	

	public String getServers() {
		return servers;
	}

	public void setServers(String servers) {
		this.servers = servers;
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getBlackDates() {
		return blackDates;
	}

	public void setBlackDates(String blackDates) {
		this.blackDates = blackDates;
	}

	public HashMap<Integer, Date> getDtq_dateList() {
		return dtq_dateList;
	}

	public void setDtq_dateList(HashMap<Integer, Date> dtq_dateList) {
		this.dtq_dateList = dtq_dateList;
	}

	public HashMap<Integer, Date> getProd_dateList() {
		return prod_dateList;
	}

	public void setProd_dateList(HashMap<Integer, Date> prod_dateList) {
		this.prod_dateList = prod_dateList;
	}

	public HashMap<Integer, Date> getWinDtq() {
		return winDtq;
	}

	public void setWinDtq(HashMap<Integer, Date> winDtq) {
		this.winDtq = winDtq;
	}
	

	
}
