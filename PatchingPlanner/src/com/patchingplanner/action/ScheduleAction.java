package com.patchingplanner.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.patchingplanner.DAO.SearchDAO;
import com.patchingplanner.SchedulingUtilities.SchedulingList;
import com.patchingplanner.SchedulingUtilities.ScheduleDates;
import com.patchingplanner.SchedulingUtilities.SchedulingServerList;
import com.patchinplanner.bean.ServerBean;


public class ScheduleAction {

	private Date startdate;
	private Date enddate;
	private String patchlist;
	private ArrayList<Date> dtqdate = new ArrayList<Date>();
	private ArrayList<Date> proddate = new ArrayList<Date>();
	private ArrayList<ServerBean> ilm_dtq = new ArrayList<ServerBean>();
	private ArrayList<ServerBean> ss_dtq = new ArrayList<ServerBean>();
	private ArrayList<ServerBean> vp_dtq = new ArrayList<ServerBean>();
	private ArrayList<ServerBean> ilm_prod = new ArrayList<ServerBean>();
	private ArrayList<ServerBean> ss_prod = new ArrayList<ServerBean>();
	private ArrayList<ServerBean> vp_prod = new ArrayList<ServerBean>();
	private ArrayList<ServerBean> schArray = new ArrayList<ServerBean>();
	private SearchDAO ssDao =  new SearchDAO();
	
	public String getPatchlist() {
		return patchlist;
	}
	public void setPatchlist(String patchlist) {
		this.patchlist = patchlist;
	}
	

	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	
	
	public String execute(){
				
			ScheduleDates schedule = new ScheduleDates();
			SimpleDateFormat fmt = new SimpleDateFormat("E dd-MM-yyyy");
			schedule.scheduleDates(startdate, enddate);
			dtqdate = SchedulingList.getDtqDates();
			proddate = SchedulingList.getProdDates();
		
		schArray = ssDao.getServers(patchlist);
		
			SchedulingServerList server_gen = new SchedulingServerList();
				server_gen.genarateList(schArray);
				
				ilm_dtq = SchedulingList.getIlm_dtq();
				ss_dtq = SchedulingList.getSs_dtq();
				vp_dtq = SchedulingList.getVp_dtq();
				ilm_prod = SchedulingList.getIlm_prod();
				ss_prod = SchedulingList.getSs_prod();
				vp_prod = SchedulingList.getVp_prod();
				
				
		
		for(int i = 0 ; i < dtqdate.size(); i++){
			System.out.println(fmt.format(dtqdate.get(i))+"dtq");
		}
		for(int i = 0 ; i < proddate.size(); i++){
			System.out.println(fmt.format(proddate.get(i))+"prod");
		}
		for(int i = 0; i< schArray.size() ; i++){
			System.out.println(schArray.get(i));
		}
		
		
		
		return "success";
	}
	
}
