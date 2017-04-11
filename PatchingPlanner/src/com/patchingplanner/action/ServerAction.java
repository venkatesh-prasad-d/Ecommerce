package com.patchingplanner.action;

import java.util.ArrayList;

import com.patchingplanner.DAO.AllServerDAO;
import com.patchinplanner.bean.ServerBean;

public class ServerAction {
	
	private AllServerDAO server = new AllServerDAO();
	private ServerBean sb = new ServerBean();
	ArrayList<ServerBean> arraBean = new ArrayList<ServerBean>();
	public ServerBean getSb() {
		return sb;
	}
	public void setSb(ServerBean sb) {
		this.sb = sb;
	}
	public ArrayList<ServerBean> getArraBean() {
		return arraBean;
	}
	public void setArraBean(ArrayList<ServerBean> arraBean) {
		this.arraBean = arraBean;
	} 
	
	public String execute(){
		
		arraBean = server.getServer(sb);
		
		return "success";
		
	}

}
