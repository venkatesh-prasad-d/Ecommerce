package com.StatusReportingTool.Bean;

	/**
	 * LoginBean.java
	 * Purpose: Bean class.
	 *
	 * @author Venkatesh Prasad D
	 * @version 1.0 6/18/2017
	 */
public class LoginBean {
	private String uname;
	private String pass;
	private String name;
	Boolean valid;
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

}
