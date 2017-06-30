package com.StatusReportingTool.Bean;

	/**
	 * RegisterBean.java
	 * Purpose: Bean class.
	 *
	 * @author Venkatesh Prasad D
	 * @version 1.0 6/18/2017
	 */

public class RegisterBean {
	private String uid;
	private String name;
	private String pass;
	private String cpass;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getCpass() {
		return cpass;
	}
	public void setCpass(String cpass) {
		this.cpass = cpass;
	}

}
