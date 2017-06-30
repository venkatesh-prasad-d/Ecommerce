package com.StatusReportingTool.Action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.StatusReportingTool.Bean.LoginBean;
import com.StatusReportingTool.DAO.LoginDAO;
import com.mysql.jdbc.StringUtils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * LoginAction.java
 * Purpose: Validation Of the user.
 *
 * @author Venkatesh Prasad D
 * @version 1.0 6/18/2017
 */
public class LoginAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;

	private SessionMap<String,Object> sessionMap ;
	LoginBean loginbean = new LoginBean();
	LoginDAO lDao = new LoginDAO();
	boolean valid;
	
	/**
	 * Validates the input form fields
	 *
	 * @return Error.
	 */
	public void validate(){
		if(StringUtils.isEmptyOrWhitespaceOnly((loginbean.getUname())))	{
			addFieldError("loginbean.uname", "Username Can't be empty");
		}
		if(StringUtils.isEmptyOrWhitespaceOnly(loginbean.getPass())){
			addFieldError("loginbean.pass","Password Can't be empty");
		}
	}
	
	/**
	 * Validates the user based on the credentials
	 *
	 * @return String.
	 */
	public String login()  {		
		
		loginbean = lDao.validate(loginbean);
		valid = loginbean.getValid();
		if(valid == true){ // if the user is valid then begin session
			sessionMap.put("username", loginbean.getUname()); 
			sessionMap.put("name", loginbean.getName());			
			return "SUCCESS" ;
		}	else{ // else display an error message
			addActionError("Invalid Username or Password");
			return "ERROR";
		}
	}
	
	/**
	 * Getters and setters for bean and session 
	 */
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
