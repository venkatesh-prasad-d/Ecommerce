package com.patchingplanner.SchedulingUtilities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ScheduleDates {
	ArrayList<Date> dtqdates = new ArrayList<Date>();
	ArrayList<Date> proddates = new ArrayList<Date>();
	Calendar calendar = Calendar.getInstance();
	SchedulingList date = new SchedulingList();

	public void scheduleDates(Date start, Date end){
		
				Date newDate = getDate(start);
			
				while(newDate.before(end)){
					
					calendar.setTime(newDate);
					if(calendar.get(Calendar.DAY_OF_MONTH) < 16){
						dtqdates.add(newDate);
						System.out.println("dtq"+newDate);
					}else{
						proddates.add(newDate);
						System.out.println("prod"+newDate);
					}
					
					int day_of_week = calendar.get(Calendar.DAY_OF_WEEK);
					
					if(day_of_week > 4 ){
						calendar.add(Calendar.DAY_OF_WEEK, 4);
					}else{
						calendar.add(Calendar.DAY_OF_WEEK, 1);
					}
					 newDate = calendar.getTime();
				}				
				date.setDtqDates(dtqdates);
				date.setProdDates(proddates);
				
				
		
	}
		public Date getDate(Date start){
			
			calendar.setTime(start);
			
			int day = calendar.get(Calendar.DAY_OF_WEEK);
			switch(day){
				case 6:calendar.add(Calendar.DAY_OF_WEEK, 3);
						break;					
				case 7:calendar.add(Calendar.DAY_OF_WEEK,2);
						break;				
				case 1:calendar.add(Calendar.DAY_OF_WEEK, 1);
			}
				Date newDate = calendar.getTime();
				
				return newDate;
			
		}
}
