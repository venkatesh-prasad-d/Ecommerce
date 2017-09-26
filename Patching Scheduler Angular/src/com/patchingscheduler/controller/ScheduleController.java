package com.patchingscheduler.controller;


import java.text.ParseException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.patchingscheduler.DAO.DateDAO;
import com.patchingscheduler.DAO.ScheduleDAO;
import com.patchingscheduler.model.DateBean;
import com.patchingscheduler.model.ScheduleBean;
import com.patchingscheduler.model.ServerBean;
import com.patchingscheduler.model.UtilityBean;
import com.patchingscheduler.utilities.PatchingUtilities;
import com.patchingscheduler.utilities.ScheduleServers;
import com.patchingscheduler.utilities.ServerSeperation;

@Controller
public class ScheduleController {
	
	@Autowired
	ScheduleDAO scheduleDAO;
	@Autowired
	PatchingUtilities patching;
	@Autowired
	ScheduleServers scheduleServers;
	@Autowired
	UtilityBean utilityBean;
	@Autowired
	DateDAO dateDAO;
	@Autowired
	ServerSeperation serverUtilities;
	
	
	ScheduleBean bean = new ScheduleBean();

	
	@RequestMapping(value="/", method = RequestMethod.GET )
	public ModelAndView getMethod(){	
		return new ModelAndView("Schedule","ServerList",new ScheduleBean());
	}
	
	@RequestMapping(value="/dateForm" , method = RequestMethod.GET)
	public ModelAndView getDateMethod() {
		return new ModelAndView("Dates","b_dates", new DateBean());
	}
	
	@RequestMapping(value="/dateForm",method = RequestMethod.POST)
	public ModelAndView postDateMethod(@ModelAttribute("b_dates")DateBean dateBean) throws ParseException {
				
				String str_dates = dateBean.getBlack_dates();
				String[] dates = str_dates.split(",");
				
				dateDAO.addDates(dates);
				System.out.println("Dates");	
				return new ModelAndView("Schedule","ServerList",new ScheduleBean());
	}
	
	@RequestMapping(value="Rest/scheduleServer", method = RequestMethod.POST,produces="application/json",consumes="application/json")
	public @ResponseBody ArrayList<ServerBean> getServer(@RequestBody ScheduleBean schedule) {
		
		ArrayList<ServerBean> serverList = new ArrayList<ServerBean>();
		ArrayList<ServerBean> dtq_servers = new ArrayList<ServerBean>();
		ArrayList<ServerBean> prod_sa = new ArrayList<ServerBean>();
		ArrayList<ServerBean> prod_ws = new ArrayList<ServerBean>();
		ArrayList<ServerBean> scheduleList = new ArrayList<ServerBean>();
		ArrayList<ArrayList<ServerBean>> model = new ArrayList<ArrayList<ServerBean>>();
		System.out.println(schedule.getEndDate()+" "+schedule.getStartDate());
		String[] servers = schedule.getServers().trim().split(","); 		
		servers = StringUtils.trimArrayElements(servers);
		
		System.out.println(servers.length+"length");
		serverList = scheduleDAO.getServerList(servers);
		System.out.println("ServerList Size : " + serverList.size());
		
		int[] bdates = {0};
		
		bdates = dateDAO.getDates(schedule.getStartDate(), schedule.getEndDate());
		
		
		utilityBean = patching.patchingDates(schedule.getStartDate(),schedule.getEndDate(), bdates);		
		
		
		utilityBean = serverUtilities.serpateServers(serverList,utilityBean);
				
		scheduleList = scheduleServers.scheduleServers(utilityBean);
		System.out.println("dev "+dtq_servers.size() +" prod_sa "+prod_sa.size() +" prod_ws "+prod_ws.size()+"Start Date"+ schedule.getStartDate()+"End Date"+schedule.getEndDate());
		
		model.add(scheduleList);
		model.add(utilityBean.getDtq_servers());
		model.add(utilityBean.getProd_sa());
		model.add(utilityBean.getProd_ws());
		model.add(utilityBean.getWin_dtq());
		model.add(utilityBean.getWin_even());
		model.add(utilityBean.getWin_odd());
		
			
		return scheduleList;
	}


	
	

}
