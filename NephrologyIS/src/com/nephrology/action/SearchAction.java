package com.nephrology.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.nephrology.DAO.SearchHistorical;
import com.nephrology.DAO.SearchOnGoing;
import com.nephrology.bean.SearchBean;
import com.nephrology.bean.SearchOGBean;

public class SearchAction implements SessionAware  {
	private SessionMap<String,Object> sessionMap ;
	SearchBean searchbean = new SearchBean();
	SearchOGBean searchogbean = new SearchOGBean();
	ArrayList<SearchBean> searchlist =new ArrayList<SearchBean>();
	ArrayList<SearchOGBean> searchOGlist =new ArrayList<SearchOGBean>();
	SearchOnGoing search = new SearchOnGoing();
	SearchHistorical searchHist = new SearchHistorical();
	Date startDate ;
	Date endDate;

	public String execute() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(searchbean.getPatientId()+"SearchAction");
		if(searchbean.getDate().equals("All")){
			System.out.println(searchbean.getDate());
			searchlist = searchHist.getALLData(searchbean);
			
		}else if(searchbean.getDate().contains("On Going")){
			
			if(searchbean.getPatientId() != null){
				searchogbean.setPatientId(sessionMap.get("patientId").toString());
				searchOGlist = search.getData(searchogbean);
				sessionMap.put("patientId",sessionMap.get("patientId").toString() );
				return "OnGoing";
			}else{
				System.out.println(sessionMap.get("patientId").toString());
				searchogbean.setPatientId(sessionMap.get("patientId").toString());
			}
			return "OnGoing";			
			
		}else{
		startDate = (Date) sdf.parse(searchbean.getDate());
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		endDate = cal.getTime();
		Timestamp sdate = new Timestamp(startDate.getTime());
		Timestamp edate = new Timestamp(endDate.getTime());
		System.out.println(sdate);
		
		searchlist = searchHist.getSpecificData(searchbean, sdate, edate);
		System.out.println(searchlist.size()+"In action");
		}
		return "success";
		
	}

	public ArrayList<SearchBean> getSearchlist() {
		return searchlist;
	}

	public void setSearchlist(ArrayList<SearchBean> searchlist) {
		this.searchlist = searchlist;
	}

	public ArrayList<SearchOGBean> getSearchOGlist() {
		return searchOGlist;
	}

	public void setSearchOGlist(ArrayList<SearchOGBean> searchOGlist) {
		this.searchOGlist = searchOGlist;
	}

	public SearchBean getSearchbean() {
		return searchbean;
	}

	public void setSearchbean(SearchBean searchbean) {
		this.searchbean = searchbean;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}
}
