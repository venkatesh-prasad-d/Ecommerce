package com.patchingscheduler.utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


import org.apache.commons.lang.time.DateUtils;

import com.patchingscheduler.model.ScheduleBean;
import com.patchingscheduler.model.UtilityBean;

public class PatchingUtilities {
	
                 
	
	@SuppressWarnings("deprecation")
	public UtilityBean patchingDates(Date startDate, Date endDate,int[] blackDates) {
		UtilityBean utilityBean = new UtilityBean();
		SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
		HashMap<Integer,Date> dtq_dateList = new HashMap<Integer, Date>();
		HashMap<Integer,Date> prod_dateList = new HashMap<Integer, Date>();	
		HashMap<Integer,Date> win_dateList = new HashMap<Integer,Date>(); 
		Date currentDate = startDate;
		Date mid_Date = new Date();
		
		mid_Date.setDate(15);
		mid_Date.setMonth(startDate.getMonth());
		mid_Date.setYear(startDate.getYear());
		Date winDtq = new Date();
		winDtq.setDate(16);
		winDtq.setMonth(startDate.getMonth());
		winDtq.setYear(startDate.getYear());
		//System.out.println("Test" + currentDate);
		int date;
		endDate = DateUtils.addDays(endDate, 1);
		System.out.println(endDate);
		while(currentDate.before(endDate)) {
			//System.out.println("Dtq" + currentDate);
			if(currentDate.before(mid_Date)) {
				date = currentDate.getDate();			
				if(currentDate.getDay()  > 4) {
					currentDate = DateUtils.addDays(currentDate, 3);
				}else if(currentDate.getDay() == 0) {
					currentDate = DateUtils.addDays(currentDate, 1);
				}else {
					System.out.println("Dtq" + currentDate);
					dtq_dateList.put(date, currentDate);
					currentDate = DateUtils.addDays(currentDate, 1);
				}
			}else {
				date = currentDate.getDate();	
				int pre_date = currentDate.getDay();
				
				if(pre_date  > 4) {
					currentDate = DateUtils.addDays(currentDate, 4);
					
				}else if(pre_date == 1 || pre_date == 3){					
					currentDate = DateUtils.addDays(currentDate, 1);
				}
				else {
					prod_dateList.put(date, currentDate);
					System.out.println(currentDate+"Prod Dtaes");
					currentDate = DateUtils.addDays(currentDate, 1);					
				}			
			}					
		}
		while(winDtq.before(endDate)) { 
			//System.out.println("Dtq" + currentDate);	
			int win_date = winDtq.getDate();
			int win_day = winDtq.getDay();
				if(win_day  > 5) {
					winDtq = DateUtils.addDays(winDtq, 2);
				}else if(win_day == 0|| win_day == 2 || win_day == 4) {
					winDtq = DateUtils.addDays(winDtq, 1);
				}else {
					System.out.println("Dtq win" + winDtq);
					win_dateList.put(win_date, winDtq);
					winDtq = DateUtils.addDays(winDtq, 1);
				}
			}
		
		
		for(int i = 0 ; i < blackDates.length;i++) {
			int black_date = blackDates[i];
			
			if(black_date <= 15) {
				dtq_dateList.remove(black_date);
			}else {
				prod_dateList.remove(black_date);
				win_dateList.remove(black_date);
			}		
		}
		
		utilityBean.setDtq_dateList(dtq_dateList);
		utilityBean.setProd_dateList(prod_dateList);
		utilityBean.setWinDtq(win_dateList);
		return utilityBean;
		
		
		
	}

}
