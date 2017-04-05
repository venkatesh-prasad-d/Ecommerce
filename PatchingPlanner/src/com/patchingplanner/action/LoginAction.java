package com.patchingplanner.action;

import com.opensymphony.xwork2.ActionSupport;
import com.patchingplanner.DAO.LoginDAO;
import com.patchinplanner.bean.LoginBean;

public class LoginAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uname;
	private String pass;
	LoginBean loginbean = new LoginBean();
	public LoginBean getLoginbean() {
		return loginbean;
	}


	public void setLoginbean(LoginBean loginbean) {
		this.loginbean = loginbean;
	}


	LoginDAO lDao = new LoginDAO();
	boolean valid;

	

	
	
	


	public String execute()  {
		System.out.println("hi");
		//lBean.setUname(getUname());
		//lBean.setPass(getPass());
		
		valid = lDao.validate(loginbean);
		
		if(valid == true){
			return "SUCCESS" ;
		}	else{
			return "ERROR";
		}
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}

}
