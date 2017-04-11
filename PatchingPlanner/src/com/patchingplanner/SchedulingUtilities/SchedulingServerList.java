package com.patchingplanner.SchedulingUtilities;

import java.util.ArrayList;

import com.patchinplanner.bean.ServerBean;

public class SchedulingServerList {
	
	private ArrayList<ServerBean> ilm_dtq = new ArrayList<ServerBean>();
	private ArrayList<ServerBean> ss_dtq = new ArrayList<ServerBean>();
	private ArrayList<ServerBean> vp_dtq = new ArrayList<ServerBean>();
	private ArrayList<ServerBean> ilm_prod = new ArrayList<ServerBean>();
	private ArrayList<ServerBean> ss_prod = new ArrayList<ServerBean>();
	private ArrayList<ServerBean> vp_prod = new ArrayList<ServerBean>();
	
	public void genarateList(ArrayList<ServerBean> array_servers){
		for(int i = 0; i < array_servers.size(); i++){
			
			if(array_servers.get(i).getCategory().equals("ILM")&&(array_servers.get(i).getEnvironment() !="PROD")){
				ilm_dtq.add(array_servers.get(i));
			}else if(array_servers.get(i).getCategory().equals("SITEMINDER")&&(array_servers.get(i).getEnvironment() !="PROD")){
				ss_dtq.add(array_servers.get(i));
			}else if(array_servers.get(i).getCategory().equals("VENDOR PORTAL")&&(array_servers.get(i).getEnvironment() !="PROD")){
				vp_dtq.add(array_servers.get(i));
			}else if(array_servers.get(i).getCategory().equals("ILM")&&(array_servers.get(i).getEnvironment().equals("PROD"))){
				ilm_prod.add(array_servers.get(i));
			}else if(array_servers.get(i).getCategory().equals("SITEMINDER")&&(array_servers.get(i).getEnvironment().equals("PROD"))){
				ss_prod.add(array_servers.get(i));
			}else if(array_servers.get(i).getCategory().equals("VENDOR PORTAL")&&(array_servers.get(i).getEnvironment().equals("PROD"))){
				vp_prod.add(array_servers.get(i));
			}
			
			SchedulingList.setIlm_dtq(ilm_dtq);
			SchedulingList.setSs_dtq(ss_dtq);
			SchedulingList.setVp_dtq(vp_dtq);
			SchedulingList.setIlm_prod(ilm_prod);
			SchedulingList.setSs_prod(ss_prod);
			SchedulingList.setVp_prod(vp_prod);
			
			
			
		}
	}

}
