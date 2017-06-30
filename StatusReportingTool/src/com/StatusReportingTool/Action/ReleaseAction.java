package com.StatusReportingTool.Action;

import java.util.ArrayList;
import java.util.List;

import com.StatusReportingTool.Bean.FixesBean;
import com.StatusReportingTool.Bean.ReleaseBean;
import com.StatusReportingTool.DAO.FixesDAO;
import com.StatusReportingTool.DAO.ReleaseDAO;

public class ReleaseAction {
	
	ReleaseBean releaseBean = new ReleaseBean();
	FixesBean fixesBean = new FixesBean();
	ReleaseDAO releaseDAO = new ReleaseDAO();
	FixesDAO fixesDAO = new FixesDAO();
	ArrayList<ReleaseBean> releaseList = new ArrayList<ReleaseBean>();
	ArrayList<FixesBean> fixesList = new ArrayList<FixesBean>();
	List<String> fnfId ;
	
	public String getRelease(){
		
		releaseList = releaseDAO.getReleaseList(releaseBean);
		return "success";
		
	}
	
	public String addRelease(){
		fixesList = fixesDAO.releaseFixes(fnfId);
		int releaseId = releaseBean.getReleaseID();
		for(int i = 0; i < fixesList.size(); i++){
			ReleaseBean rBean = new ReleaseBean();
			rBean.setReleaseID(releaseId);
			rBean.setFnfID(fixesList.get(i).getFnfId());
			rBean.setItem(fixesList.get(i).getItem());
			releaseList.add(rBean);
		}
		releaseDAO.addRelease(releaseList);
		return "success";
		
	}

	public ArrayList<ReleaseBean> getReleaseList() {
		return releaseList;
	}

	public void setReleaseList(ArrayList<ReleaseBean> releaseList) {
		this.releaseList = releaseList;
	}

	public ReleaseBean getReleaseBean() {
		return releaseBean;
	}

	public void setReleaseBean(ReleaseBean releaseBean) {
		this.releaseBean = releaseBean;
	}

	public List<String> getFnfId() {
		return fnfId;
	}

	public void setFnfId(List<String> fnfId) {
		this.fnfId = fnfId;
	}

}
