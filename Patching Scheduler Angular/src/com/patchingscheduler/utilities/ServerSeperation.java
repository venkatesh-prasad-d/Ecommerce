package com.patchingscheduler.utilities;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.patchingscheduler.model.ServerBean;
import com.patchingscheduler.model.UtilityBean;

public class ServerSeperation {

	
	public UtilityBean serpateServers(ArrayList<ServerBean> serverList,UtilityBean utilityBean) {
		ServerBean server;
		ArrayList<ServerBean> dtq_servers = new ArrayList<ServerBean>();
		ArrayList<ServerBean> prod_sa = new ArrayList<ServerBean>();
		ArrayList<ServerBean> prod_ws = new ArrayList<ServerBean>();
		ArrayList<ServerBean> win_dtq = new ArrayList<ServerBean>();
		ArrayList<ServerBean> win_odd = new ArrayList<ServerBean>();
		ArrayList<ServerBean> win_even = new ArrayList<ServerBean>();
		
		for(int i = 0; i < serverList.size(); i++ ) {
			server = serverList.get(i);
			String envi = server.getEnvironment();
			String server_name = server.getName().toLowerCase();
			String type = server.getType().toLowerCase();
						
			 {
			if(!envi.equalsIgnoreCase("prod")) {
				
				if(type.contains("windows")) {
					win_dtq.add(server);
				}else {
					dtq_servers.add(server);
				}
			
			}else{
				if(type.contains("windows")) {
					if(server_name.contains("1")||server_name.contains("3")||server_name.contains("5")||server_name.contains("7")) {
						win_odd.add(server);  
					}else {
						win_even.add(server);
					}
				}
				else if(server_name.contains("prdsa")) {
					prod_sa.add(server);
				}else{
					prod_ws.add(server);
				}				
			}
			
		}
		}
		utilityBean.setDtq_servers(dtq_servers);
		utilityBean.setProd_sa(prod_sa);
		utilityBean.setProd_ws(prod_ws);
		utilityBean.setWin_dtq(win_dtq);
		utilityBean.setWin_odd(win_odd);
		utilityBean.setWin_even(win_even);
		return utilityBean;	
	}

}
