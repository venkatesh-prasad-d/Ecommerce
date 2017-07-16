package com.nephrology.action;

import org.apache.commons.lang.StringUtils;

import com.nephrology.DAO.RegisterDAO;
import com.nephrology.bean.RegisterBean;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	RegisterBean registerbean = new  RegisterBean();
	RegisterDAO registerDAO = new RegisterDAO();
	Boolean addedUser = false;
	public void validate(){
		if(StringUtils.isEmpty(registerbean.getUsername()))	{
			addFieldError("registerbean.username", "UID Can't be empty");
		}
		if(StringUtils.isEmpty(registerbean.getDocName())){
			addFieldError("registerbean.name","Name Can't be empty");
		}
		if(StringUtils.isEmpty(registerbean.getPassword()))	{
			addFieldError("registerbean.password", "Password Can't be empty");
		}
	/*	if(StringUtils.isEmpty(registerbean.getCpass())){
			addFieldError("registerbean.cpass","Please Re-enter Password");
		}
		if(! StringUtils.equals(registerbean.getPassword(), registerbean.getCpass())){
		
			addFieldError("registerbean.pass","Password Doesn't match");
		}*/
	}
	
	public RegisterBean getRegisterbean() {
		return registerbean;
	}

	public void setRegisterbean(RegisterBean registerbean) {
		this.registerbean = registerbean;
	}
	
	public String execute(){
		System.out.println("Hi from Action");
		addedUser = registerDAO.registerUser(registerbean);
		
		if(addedUser == true){
		return "success";
		}else{
			return "error";
		}
	
	
	
	}
	

}
