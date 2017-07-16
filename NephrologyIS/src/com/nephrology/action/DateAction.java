package com.nephrology.action;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.nephrology.DAO.DateDAO;
import com.nephrology.bean.DateBean;

public class DateAction {
	
	DateBean dateBean = new DateBean();
	DateDAO dateDAO = new DateDAO();
	
	ArrayList<DateBean> dateList = new ArrayList<DateBean>();
	
	public String execute() throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		dateBean.setDoc_id("1asd2");
		
		System.out.println(dateBean.getDate()+"junk");
		System.out.println(dateBean.getPatientid());
		dateList = dateDAO.getDates(dateBean);
		System.out.println("hi"+dateList.size());
		for(int i = 0; i < dateList.size(); i++){
			//dateList.get(i).setDate( format.parse(format.format(dateList.get(i).getDate())));
			System.out.println(dateList.get(i).getDate());
		}
		
		
		return "success";
		
		
	}



	public DateBean getDateBean() {
		return dateBean;
	}



	public void setDateBean(DateBean dateBean) {
		this.dateBean = dateBean;
	}
	
	public ArrayList<DateBean> getDateList() {
		return dateList;
	}



	public void setDateList(ArrayList<DateBean> dateList) {
		this.dateList = dateList;
	}


}
