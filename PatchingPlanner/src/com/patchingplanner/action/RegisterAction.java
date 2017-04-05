package com.patchingplanner.action;

import com.opensymphony.xwork2.ActionSupport;
import com.patchingplanner.DAO.RegisterDAO;
import com.patchinplanner.bean.RegisterBean;

public class RegisterAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RegisterBean registerbean = new RegisterBean();
	RegisterDAO rDao = new RegisterDAO();
	public RegisterBean getRegisterbean() {
		return registerbean;
	}
	public void setRegisterbean(RegisterBean registerbean) {
		this.registerbean = registerbean;
	}
	
	/*public void validate(){
		if(!registerbean.getPass().equals(registerbean.getCpass())){
			addFieldError("pass","Password Doesn't match");
		}
	}*/
	
	public String execute(){
		System.out.println("Hi from action");
		System.out.println(registerbean.getUid()+registerbean.getName()+registerbean.getPass());
		
		boolean flag = rDao.addNewUser(registerbean);
		if(flag == true){
			return "success";
		}else{
			return "error";
		}
	}

}
