package com.nephrology.DAO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.hibernate.utilities.HibernateUtilities;
import com.nephrology.bean.DateBean;

public class DateDAO {
	
	ArrayList<DateBean> dateList = new ArrayList<DateBean>();
	SessionFactory factory;
	Session session;
	Transaction tx = null;
	
	public ArrayList<DateBean> getDates(DateBean datebean){
		
		factory = HibernateUtilities.getSessionFactory();
		session = factory.openSession();
		System.out.println(factory);
				
		try{
			tx = session.beginTransaction();
			System.out.println(datebean.getDoc_id()+datebean.getPatientid());
			
			Criteria cs = session.createCriteria(DateBean.class);
			Criterion idPatient = Restrictions.ilike("patientid", datebean.getPatientid());//session.createCriteria(DateBean.class);
			//idPatient.add(Restrictions.ilike("patientId", datebean.getPatientId()));
			Criterion idDoc = Restrictions.ilike("doc_id", datebean.getDoc_id());
			Conjunction addConjunction = Restrictions.conjunction();
			addConjunction.add(idPatient);
			addConjunction.add(idDoc);
			cs.add(addConjunction); 
			System.out.println(cs);
			System.out.println(datebean.getPatientid());
			//cs.add(Restrictions.ilike("patientId", datebean.getPatientId().trim()));
			
			dateList = (ArrayList<DateBean>) cs.list();
			DateBean db = new DateBean();
			DateBean db1 = new DateBean();
		//	Calendar cal = Calendar.getInstance();
			//db.setDate(cal.getTime());
			db1.setDateList1("All");
			dateList.add(db1);
			db.setDateList1("On Going Dialysis");
			dateList.add(db);
			System.out.println(dateList.size());
			System.out.println(dateList.get(0).getDate());
			Collections.reverse(dateList);
			tx.commit();
			
		}catch(HibernateException e){
			 if(tx != null){
				 tx.rollback();
				 System.out.println(e);
			 }
			 
		 }finally{
			 session.close();
			 
		 }
		return dateList;
		
	}

}
