package com.patchingscheduler.DAO;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.patchingscheduler.model.DateBean;

import antlr.collections.List;

@Repository
@Transactional
public class DateDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	Session session;
	
	public void addDates(String[] dates) throws ParseException {
		session = sessionFactory.getCurrentSession();
		DateFormat format = new SimpleDateFormat("MM/dd/yyyy"); 
		
		for(int i = 0; i < dates.length; i++) {
			
			String str_Date = dates[i];
			DateBean bean = new DateBean();			
			java.util.Date date =  format.parse(str_Date);
			Date sqlDate = new Date(date.getTime());
			bean.setB_dates(sqlDate);
			session.save(bean);
		}			
	}
	
	public int[] getDates(java.util.Date sDate, java.util.Date eDate) {
		
		Date startDate,endDate;
		startDate = new Date(sDate.getTime());
		endDate = new Date(eDate.getTime());
		
		ArrayList<DateBean> dateList = new ArrayList<DateBean>() ;
			session = sessionFactory.getCurrentSession();
			Criteria cs = session.createCriteria(DateBean.class);
			
			cs.add(Restrictions.ge("b_dates", startDate));
			cs.add(Restrictions.le("b_dates", endDate));
			dateList = (ArrayList<DateBean>) cs.list();
			int[] dates = new int[dateList.size()];
			System.out.println(dateList.size());
			for(int i = 0; i < dateList.size();i++) {				
				dates[i] = dateList.get(i).getB_dates().getDate();
			}
			
		return dates;	
		
	}

}
