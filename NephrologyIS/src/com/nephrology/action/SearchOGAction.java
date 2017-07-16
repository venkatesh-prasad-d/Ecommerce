package com.nephrology.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.nephrology.DAO.SearchOnGoing;
import com.nephrology.bean.SearchOGBean;

public class SearchOGAction implements SessionAware{
	private SessionMap<String,Object> sessionMap ;
	SearchOGBean searchogbean = new SearchOGBean();
	SearchOnGoing search = new SearchOnGoing();
	ArrayList<SearchOGBean> searchOGlist =new ArrayList<SearchOGBean>();
	
	public ArrayList<SearchOGBean> getSearchOGlist() {
		return searchOGlist;
	}

	public void setSearchOGlist(ArrayList<SearchOGBean> searchOGlist) {
		this.searchOGlist = searchOGlist;
	}

	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}
	
	@SuppressWarnings("unchecked")
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sessionMap = (SessionMap)map;
	}

	public String execute(){
		System.out.println(sessionMap.get("patientId").toString());
		searchogbean.setPatientId(sessionMap.get("patientId").toString());
		searchOGlist = search.getData(searchogbean);
		sessionMap.put("patientId",sessionMap.get("patientId").toString() );
		return "OnGoing";
	}

	


	

}
