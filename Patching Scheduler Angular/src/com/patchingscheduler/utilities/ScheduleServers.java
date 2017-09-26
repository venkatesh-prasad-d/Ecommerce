package com.patchingscheduler.utilities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import com.patchingscheduler.model.ServerBean;
import com.patchingscheduler.model.UtilityBean;

public class ScheduleServers {
	
	
	
	public ArrayList<ServerBean> scheduleServers(UtilityBean utilityBean) {
		HashMap<Integer,Date> dtq_dateList = new HashMap<Integer, Date>();
		HashMap<Integer,Date> prod_dateList = new HashMap<Integer, Date>();
		HashMap<Integer,Date> win_dateList = new HashMap<Integer, Date>();
		ArrayList<ServerBean> dtq_servers = new ArrayList<ServerBean>();
		ArrayList<ServerBean> prod_sa = new ArrayList<ServerBean>();
		ArrayList<ServerBean> prod_ws = new ArrayList<ServerBean>();
		ArrayList<ServerBean> win_dtq = new ArrayList<ServerBean>();
		ArrayList<ServerBean> win_odd = new ArrayList<ServerBean>();
		ArrayList<ServerBean> win_even = new ArrayList<ServerBean>();
		ArrayList<ServerBean> schedule = new ArrayList<ServerBean>();
	System.out.println("inside schedule");
	
	dtq_dateList = utilityBean.getDtq_dateList();
	prod_dateList = utilityBean.getProd_dateList();
	win_dateList = utilityBean.getWinDtq();
	dtq_servers = utilityBean.getDtq_servers();
	win_dtq = utilityBean.getWin_dtq();
	prod_sa = utilityBean.getProd_sa();
	prod_ws = utilityBean.getProd_ws();
	win_odd = utilityBean.getWin_odd();
	win_even = utilityBean.getWin_even();
	
	List<Date> dtq_values =new ArrayList<Date>(dtq_dateList.values());
	List<Date> prod_values = new ArrayList<Date>(prod_dateList.values());
	List<Date> win_dates = new ArrayList<Date>(win_dateList.values());
	List<Date> win_prod = new ArrayList<Date>(prod_dateList.values());
	
	/*for(int i = 0; i < dtq_key.size(); i++) {
		System.out.println(dtq_dateList.get(dtq_key.get(i))+"DTQ");
		
	}*/
	System.out.println(dtq_values.size()+"dtq_dates");
	
		while(dtq_servers.size() > 0 && dtq_values.size() > 0) {
			for(int i = 0; i < 20 ; i++) {
				ServerBean bean = new ServerBean();
				if(dtq_servers.isEmpty()) {
					break;
				}
				bean = dtq_servers.get(0);
				
				bean.setDate(dtq_values.get(0));
				schedule.add(bean);
				dtq_servers.remove(0);			
			}
			dtq_values.remove(0);
		}
		while(prod_sa.size() > 0 && prod_values.size() > 0) {
			for(int i = 0; i < 20 ; i++) {
				ServerBean bean = new ServerBean();
				if(prod_sa.isEmpty()) {
					break;
				}
				bean = prod_sa.get(0);
				bean.setDate(prod_values.get(0));
				schedule.add(bean);
				prod_sa.remove(0);			
			}
			prod_values.remove(0);
		}
		while(prod_ws.size() > 0 && prod_values.size() > 0) {
			for(int i = 0; i < 20 ; i++) {
				ServerBean bean = new ServerBean();
				if(prod_ws.isEmpty()) {
					break;
				}
				bean = prod_ws.get(0);
				bean.setDate(prod_values.get(0));
				schedule.add(bean);
				prod_ws.remove(0);			
			}
			prod_values.remove(0);
		}
		while(win_dtq.size() > 0 && win_dates.size() > 0) {
			for(int i = 0; i < 20 ; i++) {
				ServerBean bean = new ServerBean();
				if(win_dtq.isEmpty()) {
					break;
				}
				bean = win_dtq.get(0);
				bean.setDate(win_dates.get(0));
				schedule.add(bean);
				win_dtq.remove(0);			
			}
			win_dates.remove(0);
		}
		while(win_even.size() > 0 && win_prod.size() > 0) {
			Date date = win_dates.get(0);
			if(win_prod.get(0).after(date)) {
				for(int i = 0; i < 20 ; i++) {
					ServerBean bean = new ServerBean();
					if(win_even.isEmpty()) {
						break;
					}
					bean = win_even.get(0);
					bean.setDate(win_prod.get(0));
					schedule.add(bean);
					win_even.remove(0);			
				}
			}
			win_prod.remove(0);
		}
		while(win_odd.size() > 0 && win_prod.size() > 0) {
			for(int i = 0; i < 20 ; i++) {
				ServerBean bean = new ServerBean();
				if(win_odd.isEmpty()) {
					break;
				}
				bean = win_odd.get(0);
				bean.setDate(win_prod.get(0));
				schedule.add(bean);
				win_odd.remove(0);			
			}
			win_dates.remove(0);
		}
	for(int i = 0; i < schedule.size(); i++) {
		ServerBean beaned = new ServerBean();
		beaned = schedule.get(i);
		System.out.println("Name : " +beaned.getName()+ " "+"Environment : " +beaned.getEnvironment()+ " "+"Category : " +beaned.getCategory()+ " "+"Type : " +beaned.getType()+ " "+"Date : " +beaned.getDate()+ " ");
		
	}
	System.out.println("dev "+dtq_servers.size() +" prod_sa "+prod_sa.size() +" prod_ws "+prod_ws.size()+"Schedule Size" + schedule.size());
	
	return schedule;
	}

}
