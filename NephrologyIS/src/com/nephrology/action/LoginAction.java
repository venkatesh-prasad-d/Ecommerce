package com.nephrology.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.mysql.jdbc.StringUtils;
import com.nephrology.DAO.LoginDAO;
import com.nephrology.DAO.PatientDAO;
import com.nephrology.bean.LoginBean;
import com.nephrology.bean.PatientBean;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private SessionMap<String,Object> sessionMap ;
	LoginBean loginbean = new LoginBean();
	LoginDAO loginDAO = new LoginDAO();
	PatientBean patientbean = new PatientBean();
	PatientDAO patientDAO = new PatientDAO();
	Boolean valid = false;
	ArrayList<PatientBean> patientlist = new ArrayList<PatientBean>();
	
	public void validate(){
		if(StringUtils.isEmptyOrWhitespaceOnly((loginbean.getUserName())))	{
			addFieldError("loginbean.userName", "Username Can't be empty");
		}
		if(StringUtils.isEmptyOrWhitespaceOnly(loginbean.getPassword())){
			addFieldError("loginbean.password","Password Can't be empty");
		}
	}
	
	public String execute(){
		System.out.println("Inside Action");
		
		valid = loginDAO.validateUser(loginbean);
		
		if(valid == true){
			System.out.println("from action" + loginbean.getUserName());
			
			if(valid == true){ // if the user is valid then begin session
				patientbean.setDoc_id(loginbean.getDocID());
				sessionMap.put("username", loginbean.getUserName()); 
						
				return "success" ;
			}	else{ // else display an error message
				addActionError("Invalid Username or Password");
				return "ERROR";
			}
			
		
		}else{
			return "error";
		}
		
		 
	}

	public ArrayList<PatientBean> getPatientlist() {
		return patientlist;
	}

	public void setPatientlist(ArrayList<PatientBean> patientlist) {
		this.patientlist = patientlist;
	}

	public PatientBean getPatientbean() {
		return patientbean;
	}

	public void setPatientbean(PatientBean patientbean) {
		this.patientbean = patientbean;
	}

	public LoginBean getLoginbean() {
		return loginbean;
	}

	public void setLoginbean(LoginBean loginbean) {
		this.loginbean = loginbean;
	}

	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}
	
	@SuppressWarnings("unchecked")
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sessionMap = (SessionMap)map;
	}

}
