package com.patchingplanner.action;

import java.util.ArrayList;

import com.patchingplanner.DAO.SearchDAO;
import com.patchinplanner.bean.ServerBean;

public class SearchAction {
	
	private String serverlist;
	private ServerBean bean = new ServerBean();
	//private ServerBean beanview = new ServerBean();
	private SearchDAO search = new SearchDAO();
	ArrayList<ServerBean> arraBean = new ArrayList<ServerBean>();
	
	public ServerBean getBean() {
		return bean;
	}
	public void setBean(ServerBean bean) {
		this.bean = bean;
	}

	public ArrayList<ServerBean> getArraBean() {
		return arraBean;
	}
	public void setArraBean(ArrayList<ServerBean> arraBean) {
		this.arraBean = arraBean;
	}
	public String getServerlist() {
		return serverlist;
	}
	public void setServerlist(String serverlist) {
		this.serverlist = serverlist;
	}

	
		public String execute(){
			
			
		/*	String[] servers =serverlist.split(","); 
			for(int i = 0; i < servers.length; i++){
				
				String s = servers[i].trim();
				bean.setName(s);
				beanview = search.getServers(bean);
				arraBean.add(beanview);
			}*/
			arraBean = search.getServers(serverlist);
						
			return "success";
			
		}
}
	
