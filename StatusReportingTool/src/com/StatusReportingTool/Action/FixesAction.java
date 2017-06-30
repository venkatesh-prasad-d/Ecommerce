package com.StatusReportingTool.Action;

import java.util.ArrayList;

import com.StatusReportingTool.Bean.FixesBean;
import com.StatusReportingTool.DAO.FixesDAO;

public class FixesAction {
	FixesBean fixesbean = new FixesBean();
	FixesDAO fixesDAO = new FixesDAO();
	ArrayList<FixesBean> fixesList = new ArrayList<FixesBean>();
	
	public String execute(){
		
		fixesList = fixesDAO.viewFixes(fixesbean);
		return "success";
		
	}

	public FixesBean getFixesbean() {
		return fixesbean;
	}

	public void setFixesbean(FixesBean fixesbean) {
		this.fixesbean = fixesbean;
	}

	public ArrayList<FixesBean> getFixesList() {
		return fixesList;
	}

	public void setFixesList(ArrayList<FixesBean> fixesList) {
		this.fixesList = fixesList;
	}

}
