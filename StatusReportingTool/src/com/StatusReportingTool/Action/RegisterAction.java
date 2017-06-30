package com.StatusReportingTool.Action;

import org.apache.commons.lang.StringUtils;

import com.StatusReportingTool.Bean.RegisterBean;
import com.StatusReportingTool.DAO.RegisterDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Register.java
 * Purpose: Registration Of new user.
 *
 * @author Venkatesh Prasad D
 * @version 1.0 6/18/2017
 */

public class RegisterAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	RegisterBean registerbean = new RegisterBean();
	RegisterDAO rDao = new RegisterDAO();

	/**
	 * Validates the input form fields
	 *
	 * @return Error.
	 */
	
	public void validate(){
		if(StringUtils.isEmpty(registerbean.getUid()))	{
			addFieldError("registerbean.uid", "UID Can't be empty");
		}
		if(StringUtils.isEmpty(registerbean.getName())){
			addFieldError("registerbean.name","Name Can't be empty");
		}
		if(StringUtils.isEmpty(registerbean.getPass()))	{
			addFieldError("registerbean.pass", "Password Can't be empty");
		}
		if(StringUtils.isEmpty(registerbean.getCpass())){
			addFieldError("registerbean.cpass","Please Re-enter Password");
		}
		if(! StringUtils.equals(registerbean.getPass(), registerbean.getCpass())){
		
			addFieldError("registerbean.pass","Password Doesn't match");
		}
	}
	
	/**
	 * Creates new user in database based on form data
	 *
	 * @return String.
	 */
	
	public String execute(){
		
		System.out.println(registerbean.getUid()+registerbean.getName()+registerbean.getPass());
		
		boolean flag = rDao.addNewUser(registerbean);
		if(flag == true){ // If user is successfully added display success message
			addActionMessage("User added succefully");
			return "success";
		}else{ // else display error message
			addActionError("Error Adding User!!! Please Try Again");
			return "error";
		}
	}
	/**
	 * Getters and setters for bean 
	 */
	public RegisterBean getRegisterbean() {
		return registerbean;
	}
	public void setRegisterbean(RegisterBean registerbean) {
		this.registerbean = registerbean;
	}

}
